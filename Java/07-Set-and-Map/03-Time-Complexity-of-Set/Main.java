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

	private static double testSet(Set<String> set, String filename) {
		long startTime = System.nanoTime();

		ArrayList<String> words = new ArrayList<>();
		if (FileOperation.readFile("one.txt", words)) {
			System.out.println("Total words: " + words.size());

			for (String word : words)
				set.add(word);
			System.out.println("Total different words: " + set.getSize());
		}

		long endTime = System.nanoTime();
		return (endTime - startTime) / 10e9;
	}

	public static void main(String[] args) {
		ArrayList<String> words1 = new ArrayList<>();
		double time1 = testSet(new LinkedListSet<String>(), "one.txt");
		double time2 = testSet(new BSTSet<String>(), "one.txt");
		System.out.format("%.8f%n", time1);
		System.out.format("%.8f%n", time2);

		//if (FileOperation.readFile("one.txt", words1)) {
		//	System.out.println("Total words: " + words1.size());
		//
		//	BSTSet<String> set1 = new BSTSet<>();
		//	for (String word : words1)
		//		set1.add(word);
		//
		//	System.out.println("Total different words: " + set1.getSize());
		//
		//	LinkedListSet<String> list1 = new LinkedListSet<>();
		//	for (String word : words1)
		//		list1.add(word);
		//	System.out.println("Total different words: " + list1.getSize());
		//
		//}
	}
}
