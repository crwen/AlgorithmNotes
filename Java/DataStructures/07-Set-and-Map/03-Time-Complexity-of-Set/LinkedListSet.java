/**
 * ClassName: LinkedListSet
 * Description:
 * date: 2019/10/29 16:33
 *
 * @author crwen
 * @create 2019-10-29-16:33
 * @since JDK 1.8
 */
public class LinkedListSet<T> implements Set<T> {

	private LinkedList<T> list;

	public LinkedListSet() {
		list = new LinkedList<>();
	}

	@Override
	public void add(T e) {
		if (!list.contains(e)) {
			list.addFirst(e);
		}
	}

	@Override
	public void remove(T e) {
		list.removeElement(e);
	}

	@Override
	public boolean contains(T e) {
		return list.contains(e);
	}

	@Override
	public int getSize() {
		return list.getSize();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}
}
