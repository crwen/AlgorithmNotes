import org.omg.CORBA.Object;

/**
 * ClassName: SegmentTree
 * Description:
 * date: 2019/11/14 16:25
 *
 * @author crwen
 * @create 2019-11-14-16:25
 * @since JDK 1.8
 */
public class SegmentTree<T> {

	private T[] tree;
	private T[] data;

	public SegmentTree(T[] arr) {
		data = (T[]) new Object[arr.length];
		for (int i = 0; i <  arr.length; i++)
			data[i] = arr[i];

		tree = (T[]) new Object[4 * arr.length];
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
}
