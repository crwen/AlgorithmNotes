import java.util.ArrayList;

/**
 * ClassName: Main
 * Description:
 * date: 2019/12/5 19:53
 *
 * @author crwen
 * @create 2019-12-05-19:53
 * @since JDK 1.8
 */
public class Main {

	public static void main(String[] args) {
		ArrayList<String> words = new ArrayList<>();
		if (FileOperation.readFile("Trie/one.txt", words)) {
			System.out.println("Total size : " + words.size());
			long startTime = System.nanoTime();
			BSTSet<String> set = new BSTSet<>();
			for (String word : words)
				set.add(word);
			for (String word : words)
				set.contains(word);

			long endTime = System.nanoTime();
			double time = (endTime - startTime) / 1e9;
			System.out.println("BSTSet: " + time);

			startTime = System.nanoTime();
			Trie trie = new Trie();
			for (String word : words)
				trie.add(word);
			for (String word : words) {
				trie.contains(word);
			}
			endTime = System.nanoTime();
			time = (endTime - startTime) / 1e9;
			System.out.println("Trie: " + time);
		}
	}
}
