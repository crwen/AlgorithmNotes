/**
 * ClassName: BSTMap
 * Description:
 * date: 2019/10/29 19:58
 *
 * @author crwen
 * @create 2019-10-29-19:58
 * @since JDK 1.8
 */
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V>{

	private class Node {
		public K key;
		public V value;
		public Node left, right;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
			left = null;
			right = null;
		}
	}

	private Node root;
	private int size;

	public BSTMap() {
		root = null;
		size = 0;
	}

	// 返沪以 node 为根节点的二分搜索书照顾你，key所在节点
	private Node getNode(K key) {
		return getNode(root, key);
	}

	private Node getNode(Node node, K key) {
		if (node == null)
			return null;
		if (node.key.equals(key))
			return node;
		else if (key.compareTo(node.key) < 0) {
			return getNode(node.left, key);
		} else {
			return getNode(node.right, key);
		}
	}

	@Override
	public void add(K key, V value) {
		root = add(root,key, value);
	}

	// 向以 node 为根的二分搜索书中插入元素(key, value)
	// 返回插入新节点后二分搜索书的根
	private Node add(Node node, K key, V value) {
		if (node == null) {
			size++;
			return new Node(key, value);
		}
		if (key.compareTo(node.key)  < 0 ) {
			node.left = add(node.left, key, value);
		} else if (key.compareTo(node.key) > 0) {
			node.right = add(node.right, key, value);
		} else {
			node.value = value;
		}
		return node;
	}

	@Override
	public V remove(K key) {
		Node node = getNode(key);
		if (node != null) {
			root = remove(root, key);
			return node.value;
		}
		return null;
	}

	//删除以node 韦根的二分搜索树中键为key的节点
	//返回删除节点后新的二分搜索树的根
	private Node remove(Node node, K key) {
		if (node == null)
			return null;
		if (key.compareTo(node.key) < 0) {
			node.left = remove(node.left, key);
			return node;
		} else if (key.compareTo(node.key) > 0) {
			node.right = remove(node.right, key);
			return node;
		} else {
			if (node.left == null) {
				Node rightNode = node.right;
				node.right = null;
				return rightNode;
			}
			if (node.left == null) {
				Node leftNode = node.left;
				node.left = null;
				return leftNode;
			}

			Node successor = minimum(node.right);
			successor.right = removeMin(node);
			successor.left = node.left;

			node.left = node.right = null;
			return successor;
		}

	}

	private Node removeMin(Node node) {
		if (node.left == null) {
			Node rightNode = node.right;
			node.right = null;
			size--;
			return rightNode;
		}
		node.left = removeMin(node.left);
		return node;
	}

	private Node minimum(Node node) {
		if (node.left == null)
			return node;
		return minimum(node.left);
	}

	@Override
	public boolean contains(K key) {
		return getNode(key) == null ? false : true;
	}

	@Override
	public void set(K key, V newValue) {
		Node node = getNode(key);
		if (node == null)
			throw new IllegalArgumentException(key + " doesn't exist!");
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
}
