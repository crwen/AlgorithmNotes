import java.util.Random;

/**
 * ClassName: Main
 * Description:
 * date: 2019/10/30 15:47
 *
 * @author crwen
 * @create 2019-10-30-15:47
 * @since JDK 1.8
 */
public class Main {
	public static void main(String[] args) {
		int n = 1000000;

		MaxHeap<Integer> maxHeap = new MaxHeap<>();
		Random random = new Random();
		for (int i = 0; i < n; i++) {
			maxHeap.add(random.nextInt(Integer.MAX_VALUE));
			//maxHeap.add(random.nextInt(100));
		}

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = maxHeap.extractMax();
			//System.out.print(arr[i] + " ");
		}

		for (int i = 1; i < n; i++) {
			if (arr[i - 1] < arr[i]) {
				throw new IllegalArgumentException("Error");
			}
		}

		System.out.println("Test MaxHeap completed.");
	}
}
