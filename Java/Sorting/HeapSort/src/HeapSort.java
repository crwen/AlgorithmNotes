/**
 * ClassName: HeapSort
 * Description:
 * date: 2020/2/19 16:32
 *
 * @author crwen
 * @create 2020-02-19-16:32
 * @since JDK 1.8
 */
public class HeapSort {

	public static void heapSort1(Comparable[] arr) {
		Comparable[] aux = new Comparable[arr.length];
		for (int i = 0; i < arr.length; i++) {
			aux[i] = arr[i];
			shiftUp(aux, i);
		}
		int size = aux.length;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = aux[0];
			aux[0] = aux[--size];
			shiftDown(aux, 0, size);
		}
	}

	public static void heapSort2(Comparable[] arr) {

		int size = arr.length;
		for (int i = getParent(size-1) + 1; i >= 0; i--) {
			shiftDown(arr, i, size);
		}

		for (int i = 0; size > 0; i++) {
			swap(arr, 0, size-1);
			size--;
			shiftDown(arr, 0, size);
		}

	}

	private static void swap(Comparable[] arr, int i, int j) {
		Comparable tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	private static void shiftUp(Comparable[] arr, int k) {
		Comparable v = arr[k];
		int parent = 0;
		// parent = (k - 1) / 2 >= 0  ===> k >= 1
		while (k > 0 && v.compareTo(arr[parent = getParent(k)]) > 0) {
			arr[k] = arr[parent];
			k = parent;
		}
		arr[k] = v;
	}

	private static void shiftDown(Comparable[] arr, int k, int size) {
		Comparable v = arr[k];
		// left = 2 * k + 1 <= size - 1
		int left = 0;
		while ((left = getLeft(k)) < size) {
			int j = left;
			j = left + 1 < size && arr[left].compareTo(arr[left + 1]) < 0 ? left + 1 : left;
			if (v.compareTo(arr[j]) > 0)
				break;
			arr[k] = arr[j];
			k = j;
		}
		arr[k] = v;
	}
	// 根节点 为 0
	private static int getParent(int k) {
		return (k - 1) / 2;
	}

	private static int getRight(int k) {
		return (k + 1) * 2;
	}

	private static int getLeft(int k) {
		return k * 2 + 1;
	}

}
