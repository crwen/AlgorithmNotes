/**
 * ClassName: UnionFind1
 * Description:
 * date: 2019/12/7 15:00
 *
 * @author crwen
 * @create 2019-12-07-15:00
 * @since JDK 1.8
 */
public class UnionFind1 implements UF {

	/**
	 *  对应每个数据所对应的集合的编号
	 */
	private int[] id;

	public UnionFind1(int size) {
		id = new int[size];
		for (int i = 0; i < id.length; i++) {
			id[i] = i;
		}
	}

	@Override
	public int getSize() {
		return id.length;
	}

	/**
	 *  查看元素 p 和元素 q 是否属于同一个集合
	 * @param p
	 * @param q
	 * @return
	 */
	@Override
	public boolean isConnection(int p, int q) {
		return find(p) == find(q);
	}

	/**
	 *  查找元素 p 所对应的集合编号
	 * @param p
	 * @return
	 */
	private int find(int p) {
		if (p < 0 || p >= id.length)
			throw new IllegalArgumentException("index is out of bound.");
		return id[p];
	}

	/**
	 *  合并元素 p 与元素 q 所属的集合
	 * @param p
	 * @param q
	 */
	@Override
	public void unionElements(int p, int q) {
		int pID = find(p);
		int qID = find(q);

		if (pID == qID)
			return;

		for (int i = 0; i < id.length; i++) {
			if (id[i] == pID)
				id[i] = qID;
		}
	}
}
