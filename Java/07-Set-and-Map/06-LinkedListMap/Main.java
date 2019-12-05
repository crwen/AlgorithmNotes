import java.util.ArrayList;

/**
 * ClassName: Main
 * Description:
 * date: 2019/10/29 19:46
 *
 * @author crwen
 * @create 2019-10-29-19:46
 * @since JDK 1.8
 */
public class Main {

	public static void main(String[] args) {
		ArrayList<String> words = new ArrayList<>();
		if (FileOperation.readFile("Map/src/two.txt", words)) {
			System.out.println("Total words: " + words.size());
			LinkedListMap<String, Integer> listMap = new LinkedListMap<>();
			for (String word : words) {
				if (listMap.contains(word)) {
					listMap.set(word, listMap.get(word) + 1);
				} else {
					listMap.add(word, 1);
				}
			}
			System.out.println("Total different words: " + listMap.getSize());
			System.out.println(listMap);
		}
	}
}
