import java.util.TreeMap;

/**
 * ClassName: Trie
 * Description:
 * date: 2019/12/5 19:53
 *
 * @author crwen
 * @create 2019-12-05-19:53
 * @since JDK 1.8
 */
public class Trie {

	private class Node {
		/**
		 *  是否是一个单词的结尾
		 */
		public boolean isWord;
		/**
		 *  映射
		 */
		public TreeMap<Character, Node> next;

		public Node(boolean isWord) {
			this.isWord = isWord;
			next = new TreeMap<>();
		}

		public Node() {
			this(false);
		}
	}

	/**
	 *  根节点
	 */
	private Node root;

	/**
	 *  数量
	 */
	private int size;

	public Trie() {
		root = new Node();
		size = 0;
	}

	/**
	 *  获取Trie中存储的单词数量
	 * @return
	 */
	public int getSize() {
		return size;
	}

	/**
	 *  向Trie中添加一个新单词word
	 * @param word
	 */
	public void add(String word) {
		Node cur = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (cur.next.get(c) == null) {
				// 没有从该字母到节点的映射
				cur.next.put(c, new Node());
			}
			cur = cur.next.get(c);
		}
		if (!cur.isWord) {
			cur.isWord = true;
			size++;
		}
	}
}
