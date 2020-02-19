/**
 * ClassName: InsertionSort
 * Description:
 * date: 2020/2/11 14:06
 *
 * @author crwen
 * @create 2020-02-11-14:06
 * @since JDK 1.8
 */
public class InsertionSort {

	public static void insertionSort(Comparable[] arr) {
		if (arr == null || arr.length < 2)
			return;

		for (int i = 1; i < arr.length; i++) {
			Comparable e = arr[i];
			int j;
			for (j = i; j > 0 && e.compareTo(arr[j-1]) < 0; j--) {
				arr[j] = arr[j-1];
			}
			arr[j] = e;
		}
	}

	private static void swap (int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
