/**
 * ClassName: ArrayStack
 * Description:
 * date: 2019/10/21 20:32
 *
 * @author crwen
 * @create 2019-10-21-20:32
 * @since JDK 1.8
 */
public class ArrayStack<T> implements Stack<T> {
	Array<T> array;

	public ArrayStack(int capaticy) {
		array = new Array<>(capaticy);
	}

	public ArrayStack() {
		array = new Array<>();
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
	public void push(T e) {
		array.addLast((T) e);
	}

	@Override
	public T pop() {
		return array.removeLast();
	}

	@Override
	public T peek() {
		return array.getLast();
	}

	public int getCapticy() {
		return array.getCapacity();
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append("Stack: ");
		res.append("[");
		for (int i = 0; i < array.getSize(); i++) {
			res.append(array.get(i));
			if (i != array.getSize() - 1) {
				res.append(", ");
			}
		}
		res.append("] top");
		return res.toString();
	}
}
