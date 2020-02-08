/**
 * ClassName: BST
 * Description:
 * date: 2019/10/25 21:36
 *
 * @author crwen
 * @create 2019-10-25-21:36
 * @since JDK 1.8
 */
public class BST<T extends Comparable<T>> {

	private class Node {
		public T e;
		public Node left, right;

		public Node(T e) {
			this.e = e;
			this.left = null;
			this.right = null;
		}
	}

	private Node root;
	private int size;

	public BST() {
		root = null;
		size = 0;
	}

	public int size() {
		return size;
	}

	// 判断BST是否为空
	public boolean isEmpty() {
		return size == 0;
	}


	public void add(T e) {
		root = add(root, e);
	}

	// 向以node为根的二分搜索书中插入元素e, 递归算法
	//返回插入新节点后二分搜索树的根
	private Node add(Node node, T e) {
		if (node == null) {
			size++;
			return new Node(e);
		}
		if (e.compareTo(node.e) > 0) {
			node.right = add(node.right, e);
		} else if (e.compareTo(node.e) < 0){
			node.left = add(node.left, e);
		}
		return node;
	}

	// 看二分搜索树中是否包含元素e
	public boolean contains(T e) {
		return contains(root, e);
	}

	public boolean contains(Node node, T e) {
		if (node == null)
			return false;
		if (e.equals(node.e)) {
			return true;
		} else if (e.compareTo(node.e) > 0) {
			return contains(node.right, e);
		} else {
			return contains(node.left, e);
		}
	}
	//中序遍历
	public void order() {
		if (root == null)
			return;
		order(root);
	}

	public void order(Node node) {
		if (node.left != null)
			order(node.left);
		System.out.print(node.e + " ");
		if (node.right != null)
			order(node.right);
	}


	public static void main(String[] args) {
		int[] arr = {30, 28, 32, 13, 29, 31, 40};
		BST bst = new BST();
		for (int i = 0; i < arr.length; i++)
			bst.add(arr[i]);
		bst.order();
		System.out.println(bst.contains(2));
		System.out.println(bst.contains(28));
	}
}
