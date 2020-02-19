/**
 * ClassName: MergeSort
 * Description:
 * date: 2020/2/11 14:45
 *
 * @author crwen
 * @create 2020-02-11-14:45
 * @since JDK 1.8
 */
public class MergeSort {

	public static void mergeSort(Comparable[] arr) {
		if (arr == null || arr.length < 2)
			return;

		mergeSort(arr, 0, arr.length - 1);
	}

	private static void mergeSort(Comparable[] arr, int low, int high) {
		if (low >= high)
			return;
		int mid = (high - low) / 2 + low;

		mergeSort(arr, low, mid);
		mergeSort(arr, mid + 1, high);
		merge(arr, low, mid, high);
	}

	private static void merge(Comparable[] arr, int low, int mid, int high) {
		Comparable[] aux = new Comparable[high - low + 1];
		for (int i = low; i <= high; i++) {
			aux[i - low] = arr[i];
		}
		int i = low;
		int j = mid + 1;
		for (int k = low; k <= high; k++) {
			if (i > mid) {
				arr[k] = aux[j - low];
				j++;
			} else if (j > high) {
				arr[k] = aux[i - low];
				i++;
			} else if (aux[i - low].compareTo(aux[j - low]) < 0) {
				arr[k] = aux[i - low];
				i++;
			} else {
				arr[k] = aux[j - low];
				j++;
			}
		}
	}


}
