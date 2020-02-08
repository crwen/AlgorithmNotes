
/**
 * ClassName: LoopQueue
 * Description:
 * date: 2019/10/22 20:51
 *
 * @author crwen
 * @create 2019-10-22-20:51
 * @since JDK 1.8
 */
public class LoopQueue<T> implements Queue<T> {

	private T[] data;
	private int front;
	private int tail;
	private int size;

	public LoopQueue(int capacity) {
		data = (T[]) new Object[capacity + 1];
		this.front = 0;
		this.tail = 0;
		this.size = 0;
	}

	public LoopQueue() {
		this(10);
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return front == tail;
	}

	@Override
	public void enqueue(T e) {

		if ((tail + 1) % data.length == front) {
			resize(2 * getCapaticy());
		}
		data[tail] = e;
		tail = (tail + 1) % data.length;
		size++;
	}

	private void resize(int newCapaticy) {
		T[] newData = (T[]) new Object[newCapaticy + 1];
		int k = 0;
		for (int i = 0; i < size; i++) {
			newData[i] = data[i + front];
		}
		data = newData;
		front = 0;
		tail = size;
	}

	@Override
	public T dequeue() {
		if (isEmpty()) {
			throw new IllegalArgumentException("Can not dequeue from a empty queue");
		}
		T element = data[front];
		data[front] = null;
		front = (front + 1) % data.length;
		size--;
		if (size == getCapaticy() / 4 && getCapaticy() / 2 > 0) {
			resize(getCapaticy() / 2);
		}
		return element;
	}

	@Override
	public T getFront() {
		if (isEmpty()) {
			throw new IllegalArgumentException("Queue is empty");
		}
		return data[front];
	}

	public int getCapaticy() {
		return data.length - 1;
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append(String.format("Queue：size = %d, capacity = %d\n", size, data.length - 1));
		res.append("front [");
		for (int i = front; i != tail; i = (i + 1) % data.length) {
			res.append(data[i]);
			if ((i + 1) % data.length != tail) {
				res.append(", ");
			}
		}
		res.append("] tail");
		return res.toString();
	}
}
