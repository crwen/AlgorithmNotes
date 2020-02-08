/**
 * ClassName: ArrayQueue
 * Description:
 * date: 2019/10/22 20:27
 *
 * @author crwen
 * @create 2019-10-22-20:27
 * @since JDK 1.8
 */
public class ArrayQueue<T> implements Queue<T> {

	private Array<T> array;

	public ArrayQueue(int capaticy){
		array = new Array<T>(capaticy);
	}

	public ArrayQueue() {
		array = new Array<T>();
	}

	@Override
	public int getSize() {
		return array.getSize();
	}

	@Override
	public boolean isEmpty() {
		return array.isEmpty();
	}

	@Override
	public void enqueue(T e) {
		array.addLast(e);
	}

	@Override
	public T dequeue() {
		return array.removeFirst();
	}

	@Override
	public T getFront() {
		return array.get(0);
	}

	public int getCapaticy() {
		return array.getCapacity();
	}

	@Override
	public String toString() {

		StringBuilder res = new StringBuilder();
		res.append("Queue: ");
		res.append("front[");
		for (int i = 0; i < array.getSize(); i++) {
			res.append(array.get(i));
			if (i != array.getSize() - 1) {
				res.append(", ");
			}
		}
		res.append("] tail");
		return res.toString();
	}

	public static void main(String[] args) {

		ArrayQueue<Integer> queue = new ArrayQueue<>();

		for (int i = 0; i < 10; i++) {
			queue.enqueue(i);
			System.out.println(queue);

			if (i % 3 == 2) {
				queue.dequeue();
				System.out.println(queue);
			}

		}
	}
}
