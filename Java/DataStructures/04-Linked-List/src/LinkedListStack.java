
/**
 * ClassName: LinkedListStack
 * Description:
 * date: 2019/10/24 9:58
 *
 * @author crwen
 * @create 2019-10-24-9:58
 * @since JDK 1.8
 */
public class LinkedListStack<T> implements Stack<T> {

	private LinkedList<T> list;

	public LinkedListStack() {
		list = new LinkedList<>();
	}

	@Override
	public int getSize() {
		return list.getSize();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public void push(T e) {
		list.addFirst(e);
	}

	@Override
	public T pop() {
		return list.removeFirst();
	}

	@Override
	public T peek() {
		return list.getFirst();
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append("Stack: top ");
		res.append(list);
		return res.toString();
	}
}
