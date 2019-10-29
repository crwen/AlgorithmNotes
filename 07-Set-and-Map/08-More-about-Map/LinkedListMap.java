/**
 * ClassName: LinkedListMap
 * Description:
 * date: 2019/10/29 18:06
 *
 * @author crwen
 * @create 2019-10-29-18:06
 * @since JDK 1.8
 */
public class LinkedListMap<K, V> implements Map<K, V> {

	//定义节点
	private class Node {
		public K key;
		public V value;
		public Node next;

		public Node(K key, V value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}

		public Node(K key){
			this(key, null, null);
		}

		public Node() {
			this(null, null, null);
		}

		@Override
		public String toString() {
			return key.toString() + " : " + value.toString();
		}
	}

	private Node head;
	private int size;

	public LinkedListMap() {
		this.head = new Node();
		this.size = 0;
	}

	private Node getNode(K key) {
		Node cur = head.next;
		while (cur != null) {
			if (cur.key.equals(key)) {
				break;
			}
			cur = cur.next;
		}
		return cur;
	}

	@Override
	public void add(K key, V value) {
		Node node = getNode(key);
		if (node == null) {
			head.next = new Node(key, value, head.next);
			size++;
		} else {//覆盖
			node.value = value;
		}
	}

	@Override
	public V remove(K key) {

		Node pre = head;

		while (pre.next != null) {
			if (pre.next.key.equals(key)) {
				break;
			}

			pre = pre.next;
		}
		if (pre.next != null) {
			Node delNode = pre.next;
			pre.next = delNode.next;
			delNode.next = null;
			size--;
			return delNode.value;
		}

		return null;
	}

	@Override
	public boolean contains(K key) {
		return getNode(key) != null;
	}

	@Override
	public void set(K key, V newValue) {
		Node node = getNode(key);
		if (node == null)
			throw new IllegalArgumentException(key + " doesn`t exist!");
		node.value = newValue;
	}

	@Override
	public V get(K key) {
		Node node = getNode(key);
		return node == null ? null : node.value;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		Node cur = head.next;
		while(cur != null) {
			res.append(cur.key + " : " + cur.value + "\n");
			cur = cur.next;
		}
		return res.toString();
	}

	public static void main(String[] args) {
		LinkedListMap<String, Integer>  listMap = new LinkedListMap<>();
		for (int i = 0; i < 5; i++) {
			listMap.add("key" + i, i);
		}

		System.out.println(listMap);
		listMap.remove("key22");
		System.out.println(listMap);
	}
}
