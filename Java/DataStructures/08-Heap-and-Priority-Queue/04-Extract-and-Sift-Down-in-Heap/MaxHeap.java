/**
 * ClassName: MaxHeap
 * Description:
 * date: 2019/10/30 14:27
 *
 * @author crwen
 * @create 2019-10-30-14:27
 * @since JDK 1.8
 */
public class MaxHeap<T extends Comparable<T>> {

	private Array<T> data;

	public MaxHeap(int capacity) {
		data = new Array<>(capacity);
	}

	public MaxHeap() {
		data = new Array<>();
	}

	// 返回堆中元素个数
	public int size() {
		return data.getSize();
	}

	// 返回一个布尔值，表示堆中是否为空
	public boolean isEmpty() {
		return data.isEmpty();
	}

	// 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
	private int parent(int index) {
		if (index == 0)
			throw new IllegalArgumentException("indexx-0 doesn't have parent");
		return (index - 1) / 2;
	}

	// 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子的索引
	private int rightChild(int index) {
		return index * 2 + 2;
	}

	// 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子的索引
	private int leftChild(int index) {
		return index * 2 + 1;
	}

	// 向堆中添加元素
	public void add(T e) {
		data.addLast(e);
		siftUp(data.getSize() - 1);
	}

	private void siftUp(int k) {
		while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
			data.swap(k, parent(k));
			k = parent(k);
		}
	}

	// 取出堆中最大元素
	public T extractMax() {
		T res = findMax();
		data.swap(0, data.getSize() - 1);
		data.removeLast();
		siftDown(0);

		return res;
	}

	// 查看堆中的最大元素
	public T findMax() {
		if (isEmpty())
			throw new IllegalArgumentException("The heap is empty!");
		return data.get(0);
	}

	private void siftDown(int k) {
		while (leftChild(k) < data.getSize()) {

			int left = leftChild(k);
			int right = left + 1;
			int max = left;
			if (right < data.getSize() &&
					data.get(right).compareTo(data.get(left)) > 0)
				max = rightChild(k);
			// data[max] 时leftChild 和rightChild中的最大值

			if (data.get(k).compareTo(data.get(max)) > 0)
				break;

			data.swap(k, max);
			k = max;
		}
	}

}
