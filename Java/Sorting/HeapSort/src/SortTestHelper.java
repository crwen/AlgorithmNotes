import java.lang.reflect.Method;
import java.util.Random;

/**
 * ClassName: SortTestHelper
 * Description:
 * date: 2020/2/11 11:57
 *
 * @author crwen
 * @create 2020-02-11-11:57
 * @since JDK 1.8
 */
public class SortTestHelper {

	public  static  Integer[] generateRandomArray(int n, int rangeL, int rangeR) {
		Random random = new Random();
		Integer[] arr = new Integer[n];
		for (int i = 0; i < n; i++) {
			arr[i] = random.nextInt(rangeR - rangeL) + rangeL;
		}
		return arr;
	}

	public static Integer[] copyIntArray(Integer[] arr) {
		Integer[] copy = new Integer[arr.length];
		for (int i = 0; i < arr.length; i++) {
			copy[i] = arr[i];
		}
		return copy;
	}

	public static boolean isSorted(Integer[] arr) {
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < arr[i-1]) {
				System.out.println(arr[i - 1]);
				System.out.println(arr[i]);
				return false;
			}

		}
		return true;
	}

	public static  void testSort(String sortName, Class<?> clazz, Comparable[] arr) throws Exception {
		Method sort = clazz.getDeclaredMethod(sortName, Comparable[].class);
		long startTime = System.currentTimeMillis();
		sort.invoke(clazz, (Object) arr);
		long endTime = System.currentTimeMillis();
		System.out.println(sortName + ", " + (endTime - startTime) / 1e3+ "s");
	}
}
