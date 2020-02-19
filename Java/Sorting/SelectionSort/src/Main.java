/**
 * ClassName: Main
 * Description:
 * date: 2020/2/11 11:56
 *
 * @author crwen
 * @create 2020-02-11-11:56
 * @since JDK 1.8
 */
public class Main {
	public static void main(String[] args) throws Exception {
		int n = 10000;
		Integer[] arr = SortTestHelper.generateRandomArray(n, 0, n);

		SortTestHelper.testSort("selectionSort", SelectionSort.class, arr);
		System.out.println(SortTestHelper.isSorted(arr));
	}
}
