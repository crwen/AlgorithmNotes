import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * ClassName: Solution2
 * Description:
 * date: 2019/10/30 11:20
 *
 * @author crwen
 * @create 2019-10-30-11:20
 * @since JDK 1.8
 */
public class Solution2 {
	public int[] intersect(int[] nums1, int[] nums2) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		List<Integer> list = new ArrayList<>();
		for (Integer n : nums1) {
			if (map.containsKey(n)) {
				map.put(n, map.get(n) + 1);
			} else {
				map.put(n, 1);
			}
		}

		for (Integer n : nums2) {
			if (map.containsKey(n) && map.get(n) > 0) {
					list.add(n);
					map.put(n, map.get(n) - 1);
			}
		}
		int[] res = new int[list.size()];
		int index = 0;
		for (Integer n : list)
			res[index++] = n;
		return res;
	}

	public static void main(String[] args) {
		int[] nums1 = {1,2,2,1};
		int[] nums2 = {2,2};
		Solution2 res = new Solution2();
		int[] nums = res.intersect(nums1, nums2);
		System.out.println(Arrays.toString(nums));
	}
}
