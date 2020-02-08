/**
 * ClassName: BSTSet
 * Description:
 * date: 2019/10/29 16:04
 *
 * @author crwen
 * @create 2019-10-29-16:04
 * @since JDK 1.8
 */
public class BSTSet<T extends Comparable<T>> implements Set<T> {

	private BST<T> bst;

	public BSTSet() {
		bst = new BST<>();
	}

	@Override
	public void add(T e) {
		bst.add(e);
	}

	@Override
	public void remove(T e) {
		bst.remove(e);
	}

	@Override
	public boolean contains(T e) {
		return bst.contains(e);
	}

	@Override
	public int getSize() {
		return bst.size();
	}

	@Override
	public boolean isEmpty() {
		return bst.isEmpty();
	}
}
