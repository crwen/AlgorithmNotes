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

	private static double testHeap(Integer[] testData, boolean isHeapify){

		long startTime = System.nanoTime();

		MaxHeap<Integer> maxHeap;
		if(isHeapify)
			maxHeap = new MaxHeap<>(testData);
		else{
			maxHeap = new MaxHeap<>(testData.length);
			for(int num: testData)
				maxHeap.add(num);
		}

		int[] arr = new int[testData.length];
		for(int i = 0 ; i < testData.length ; i ++)
			arr[i] = maxHeap.extractMax();

		for(int i = 1 ; i < testData.length ; i ++)
			if(arr[i-1] < arr[i])
				throw new IllegalArgumentException("Error");
		System.out.println("Test MaxHeap completed.");

		long endTime = System.nanoTime();

		return (endTime - startTime) / 1000000000.0;
	}

	public static void main(String[] args) {
		int n = 10000000;

		//MaxHeap<Integer> maxHeap = new MaxHeap<>();
		Random random = new Random();

		Integer[] testData = new Integer[n];
		for (int i = 0; i < n; i++) {
			testData[i] = random.nextInt(Integer.MAX_VALUE);
		}
		double time1 = testHeap(testData, false);
		double time2 = testHeap(testData, false);
		System.out.println("Without heapify : " + time1);
		System.out.println("With heapify : " + time2);

		//for (int i = 0; i < n; i++) {
		//	maxHeap.add(random.nextInt(Integer.MAX_VALUE));
		//	//maxHeap.add(random.nextInt(100));
		//}
		//
		//int[] arr = new int[n];
		//for (int i = 0; i < n; i++) {
		//	arr[i] = maxHeap.extractMax();
		//	//System.out.print(arr[i] + " ");
		//}
		//
		//for (int i = 1; i < n; i++) {
		//	if (arr[i - 1] < arr[i]) {
		//		throw new IllegalArgumentException("Error");
		//	}
		//}

		//System.out.println("Test MaxHeap completed.");
	}
}
