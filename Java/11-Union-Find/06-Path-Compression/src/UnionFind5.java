/**
 * ClassName: UnionFind5
 * Description:
 * date: 2019/12/7 16:35
 *
 * @author crwen
 * @create 2019-12-07-16:35
 * @since JDK 1.8
 */
public class UnionFind5 implements UF {

	private int[] parent;
	private int[] rank; // 高度

	public UnionFind5(int size) {
		parent = new int[size];
		rank = new int[size];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
			rank[i] = 1;
		}
	}

	@Override
	public int getSize() {
		return parent.length;
	}

	@Override
	public boolean isConnection(int p, int q) {
		return find(p) == find(q);
	}

	/**
	 *  查找元素 p 所对应的集合编号
	 *  O(h) 复杂度，h 为树的高度
	 * @param p
	 * @return
	 */
	private int find(int p) {

		if (p < 0 || p >= parent.length)
			throw new IllegalArgumentException("index is out of bound.");

		while (p != parent[p]) {
			parent[p] = parent[parent[p]];
			p = parent[p];
		}
		return p;
	}

	@Override
	public void unionElements(int p, int q) {
		int pRoot = find(p);
		int qRoot = find(q);

		if (pRoot == qRoot)
			return;

		if (rank[pRoot] < rank[qRoot]) {
			parent[pRoot] = parent[qRoot];
		} else if (rank[qRoot] < rank[pRoot]) {
			parent[qRoot] = pRoot;
		} else {
			parent[qRoot] = pRoot;
			rank[pRoot] += 1;
		}
	}
}
