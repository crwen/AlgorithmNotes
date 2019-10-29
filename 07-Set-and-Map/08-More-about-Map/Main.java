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

	private static double testMap(String filename, Map<String, Integer> map) {
		long startTIme = System.nanoTime();

		ArrayList<String> words = new ArrayList<>();
		if (FileOperation.readFile(filename, words)) {
			//System.out.println("Total words: " + words.size());
			for (String word : words) {
				if (map.contains(word)) {
					map.set(word, map.get(word) + 1);
				} else {
					map.add(word, 1);
				}
			}
		}

		long endTime = System.nanoTime();
		return (endTime - startTIme) / 1e9;
	}


	public static void main(String[] args) {
		double time1 = testMap("Map/src/one.txt", new LinkedListMap<String, Integer>());
		double time2 = testMap("Map/src/one.txt", new BSTMap<String, Integer>());
		System.out.println(time1);
		System.out.println(time2);


		//ArrayList<String> words = new ArrayList<>();
		//if (FileOperation.readFile("Map/src/two.txt", words)) {
		//	System.out.println("Total words: " + words.size());
		//	LinkedListMap<String, Integer> listMap = new LinkedListMap<>();
		//	BSTMap<String, Integer> bstMap = new BSTMap<>();
		//	for (String word : words) {
		//		if (listMap.contains(word)) {
		//			listMap.set(word, listMap.get(word) + 1);
		//		} else {
		//			listMap.add(word, 1);
		//		}
		//
		//		if (bstMap.contains(word)) {
		//			bstMap.set(word, bstMap.get(word) + 1);
		//		} else {
		//			bstMap.add(word, 1);
		//		}
		//
		//	}
		//	System.out.println("Total different words: " + listMap.getSize());
		//	System.out.println("Total different words: " + bstMap.getSize());
		//	//System.out.println(listMap);
		//}
	}
}
