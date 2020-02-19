/**
 * ClassName: Main
 * Description:
 * date: 2020/2/19 16:51
 *
 * @author crwen
 * @create 2020-02-19-16:51
 * @since JDK 1.8
 */
public class Main {

	public static void main(String[] args) throws Exception {
		int n = 100000;
		Integer[] arr = SortTestHelper.generateRandomArray(n, 0, 100);
		SortTestHelper.testSort("heapSort1", HeapSort.class, arr);
		SortTestHelper.testSort("heapSort2", HeapSort.class, arr);
	}
}
