/**
 * ClassName: PriorityQueue
 * Description:
 * date: 2019/10/30 19:12
 *
 * @author crwen
 * @create 2019-10-30-19:12
 * @since JDK 1.8
 */
public class PriorityQueue<T extends Comparable<T>> implements Queue<T> {

	private MaxHeap<T> maxHeap;

	public PriorityQueue() {
		maxHeap = new MaxHeap<>();
	}

	@Override
	public int getSize() {
		return maxHeap.size();
	}

	@Override
	public boolean isEmpty() {
		return maxHeap.isEmpty();
	}

	@Override
	public void enqueue(T e) {
		maxHeap.add(e);
	}

	@Override
	public T dequeue() {
		//if (maxHeap == null)
		//	throw new IllegalArgumentException("The queue is empty!");
		return maxHeap.extractMax();
	}

	@Override
	public T getFront() {
		return maxHeap.findMax();
	}
}
