/**
 * ClassName: LinkedList
 * Description:
 * date: 2019/10/23 20:54
 *
 * @author crwen
 * @create 2019-10-23-20:54
 * @since JDK 1.8
 */
public class LinkedList<T> {

	private class Node {
		public T e;
		public Node next;

		public Node(T e, Node next) {
			this.e = e;
			this.next = next;
		}

		public Node(T e) {
			this(e, null
			);
		}

		public Node() {
			this(null, null);
		}
	}

	private Node head;
	private int size;

	public LinkedList() {
		head = new Node(null, null);
		size = 0;
	}

	// 获取链表中的元素个数
	public int getSize() {
		return size;
	}

	// f返沪链表是否为空
	public boolean isEmpty() {
		return size == 0;
	}

	// 在链表头添加新元素
	public void addFirst(T e) {
		add(0, e);
	}

	// 在链表中间插入元素
	public void add(int index, T e) {
		if (index < 0 || index > size) {
			throw new IllegalArgumentException("Add failed. Illegal index");
		}

		Node pre = head;
		for (int i = 0; i < index; i++) {
			pre = pre.next;
		}

		pre.next = new Node(e, pre.next);
		size++;
	}

	// 在链表末尾添加新的元素e
	public void addLast(T e) {
		add(size, e);
	}

	//获得链表的第index（0-base）个为止的元素
	public T get(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("Get failed. Illegal index");
		}
		Node cur = head.next;
		for (int i = 0; i < index; i++) {
			cur = cur.next;
		}
		return cur.e;
	}

	// 获得链表第一个元素
	public T getFirst() {
		return get(0);
	}

	//获得链表最后一个元素
	public T getLast() {
		return get(size - 1);
	}

	// 修改链表的第index个位置的元素
	public T set(int index, T e) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("Set failed. Illegal index");
		}
		Node cur = head.next;
		for (int i = 0; i < index; i++) {
			cur = cur.next;
		}
		T old = cur.e;
		cur.e = e;
		return old;
	}

	// 查找链表中是否有元素e
	public boolean contains(T e) {
		Node cur = head.next;
		while (cur != null) {
			if (cur.e.equals(e)) {
				return true;
			}
			cur = cur.next;
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();

		Node cur = head.next;
		while (cur != null) {
			res.append(cur.e + " --> ");
			cur = cur.next;
		}
		res.append("NULL");
		return res.toString();
	}

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();

		for (int i = 0; i < 5; i++) {
			list.addFirst(i);
			System.out.println(list);
		}
		list.add(2, 666);
		System.out.println(list);
	}
}
