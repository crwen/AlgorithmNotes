import java.util.Iterator;
import java.util.TreeSet;

/**
 * ClassName: Solution
 * Description:
 * date: 2019/10/29 21:10
 *
 * @author crwen
 * @create 2019-10-29-21:10
 * @since JDK 1.8
 */
public class Solution {
	public int[] intersection(int[] nums1, int[] nums2) {
		TreeSet<Integer> set1 = new TreeSet<>();
		TreeSet<Integer> set2 = new TreeSet<>();

		for (int i = 0; i < nums1.length; i++)
			set1.add(nums1[i]);
		for (int i = 0; i < nums2.length; i++) {
			if (set1.contains(nums2[i]))
				set2.add(nums2[i]);
		}
		int res[] = new int[set2.size()];
		Iterator<Integer> it = set2.iterator();
		int i= 0;
		while (it.hasNext()) {
			res[i++] = it.next();
		}
		return res;
	}
}
