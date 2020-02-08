import java.util.ArrayList;

/**
 * ClassName: Main
 * Description:
 * date: 2019/10/29 16:18
 *
 * @author crwen
 * @create 2019-10-29-16:18
 * @since JDK 1.8
 */
public class Main {
	public static void main(String[] args) {
		ArrayList<String> words1 = new ArrayList<>();
		if (FileOperation.readFile("one.txt", words1)) {
			System.out.println("Total words: " + words1.size());

			BSTSet<String> set1 = new BSTSet<>();
			for (String word : words1)
				set1.add(word);

			System.out.println("Total different words: " + set1.getSize());
		}
	}
}
