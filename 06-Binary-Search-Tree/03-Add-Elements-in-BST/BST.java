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
		if (root == null) {
			root = new Node(e);
			size++;
		} else  {
			add(root, e);
		}
	}

	private void add(Node node, T e) {
		if (node.right != null && node.left != null) {
			if (e.compareTo(node.e) > 0) {
				add(node.right, e);
			} else if (e.compareTo(node.e) < 0) {
				add(node.left, e);
			}
		} else {
			Node newnode = new Node(e);
			if (e.compareTo(node.e) > 0) {
				node.right = newnode;
			} else if (e.compareTo(node.e) < 0) {
				node.left = newnode;
			}
			size++;
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
	}
}
