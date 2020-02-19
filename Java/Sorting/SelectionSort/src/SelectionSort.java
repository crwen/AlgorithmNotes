/**
 * ClassName: SelectionSort
 * Description:
 * date: 2020/2/11 11:49
 *
 * @author crwen
 * @create 2020-02-11-11:49
 * @since JDK 1.8
 */
public class SelectionSort {

	public static  void selectionSort(Comparable[] arr) {
		if (arr.length < 2)
			return;

		for (int i = 0; i < arr.length; i++) {
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j].compareTo(arr[minIndex]) < 0 ) {
					minIndex = j;
				}
			}
			swap(arr, i, minIndex);
		}
	}

	private static void swap (Comparable[] arr, int i, int j) {
		Comparable tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
