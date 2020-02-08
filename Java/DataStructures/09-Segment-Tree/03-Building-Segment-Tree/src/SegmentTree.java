/**
 * ClassName: SegmentTree
 * Description:
 * date: 2019/11/14 16:25
 *
 * @author crwen
 * @create 2019-11-14-16:25
 * @since JDK 1.8
 */
public class SegmentTree<T>{

	private T[] tree;
	private T[] data;
	private Merger<T> merger;

	public SegmentTree(T[] arr, Merger<T> merger) {
		this.merger = merger;

		data = (T[]) new Object[arr.length];
		for (int i = 0; i <  arr.length; i++)
			data[i] = arr[i];

		tree = (T[]) new Object[4 * arr.length];
		buildSegmentTree(0, 0, data.length - 1, merger);
	}

	// 在 treeIndex的位置创建表示区间[L...R]的线段树
	private void buildSegmentTree(int treeIndex, int L, int R, Merger<T> merger) {
		if (L == R) {
			tree[treeIndex] = data[L];
			return;
		}
		int leftTreeIndex = leftChild(treeIndex);
		int rightTreeIndex = rightChild(treeIndex);

		int mid = (R - L) / 2  + L;
		buildSegmentTree(leftTreeIndex, L, mid, merger);
		buildSegmentTree(rightTreeIndex, mid + 1, R, merger);

		tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
	}

	public int getSize() {
		return data.length;
	}

	public T get(int index) {
		if (index < 0 || index >= data.length)
			throw new IllegalArgumentException("Index is illegal");
		return data[index];
	}

	// 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
	private int leftChild(int index) {
		return 2 * index + 1;
	}

	// 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
	private int rightChild(int index) {
		return 2 * (index + 1);
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append("[");
		for (int i = 0; i < tree.length; i++) {
			if (tree[i] != null)
				res.append(tree[i]);
			else
				res.append("null");
			if (i != tree.length - 1)
				res.append(", ");
		}
		res.append("]\n");
		return res.toString();
	}
}
