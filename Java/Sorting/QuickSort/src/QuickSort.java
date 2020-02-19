/**
 * ClassName: QuickSort
 * Description:
 * date: 2020/2/11 15:07
 *
 * @author crwen
 * @create 2020-02-11-15:07
 * @since JDK 1.8
 */
public class QuickSort {

	public static void quickSort(Comparable[] arr) {
		if (arr == null || arr.length < 2)
			return;
		quickSort(arr, 0, arr.length - 1);
	}

	private static void quickSort(Comparable[] arr, int low, int high) {
		if (low >= high)
			return;

		int p = partition2_2(arr, low, high);
		quickSort(arr, low, p - 1);
		quickSort(arr, p + 1, high);
	}

	// 返回 p，使得 arr[low...p-1] < arr[p] ；arr[p+1...high] > arr[p]
	private static int partition(Comparable[] arr, int low, int high) {
		Comparable e = arr[low];

		// arr[low+1...j] < v ；arr[j+1...i) > v
		int j = low;
		for (int i = low; i <= high; i++) {
			if (arr[i].compareTo(e) < 0) {
				swap(arr, j + 1, i);
				j++;
			}
		}
		swap(arr, j, low);
		return j;
	}

	private static int partition2_1(Comparable[] arr, int low, int high) {
		int i = low;
		int j = high;
		Comparable v = arr[low];

		while (i < j) {
			while (i < j && arr[j].compareTo(v) > 0) {
				j--;
			}
			if (i < j) {
				arr[i] = arr[j];
				i++;
			}
			while (i < j && arr[i].compareTo(v) < 0) {
				i++;
			}
			if (i < j) {
				arr[j] = arr[i];
				j--;
			}
		}
		arr[i] = v;


		return i;

	}

	public static int partition2_2(Comparable[] arr, int low, int high) {
		Comparable v = arr[low];
		int i = low + 1;
		int j = high;
		while (true) {
			while (j >= low + 1 && arr[i].compareTo(v) < 0) i++;
			while (i <= high && arr[j].compareTo(v) > 0) j--;
			if (i > j)
				break;
			swap(arr, i, j);
			i++;
			j--;
		}
		swap(arr, low, j);
		return j;
	}

	private static void swap(Comparable[] arr, int i, int j) {
		Comparable tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
