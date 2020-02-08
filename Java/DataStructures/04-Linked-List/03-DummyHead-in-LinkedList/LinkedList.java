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

}
