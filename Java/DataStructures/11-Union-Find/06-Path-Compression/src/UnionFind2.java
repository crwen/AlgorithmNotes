/**
 * ClassName: UnionFind2
 * Description:
 * date: 2019/12/7 15:17
 *
 * @author crwen
 * @create 2019-12-07-15:17
 * @since JDK 1.8
 */
public class UnionFind2 implements UF {

	private int[] parent;

	public UnionFind2(int size) {
		parent = new int[size];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
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

		while (p != parent[p])
			p  = parent[p];
		return p;
	}

	@Override
	public void unionElements(int p, int q) {
		int pRoot = find(p);
		int qRoot = find(q);

		if (pRoot == qRoot)
			return;

		parent[pRoot] = parent[qRoot];
	}
}
