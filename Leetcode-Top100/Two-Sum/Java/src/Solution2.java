
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: Solution2
 * Description:
 * date: 2020/3/9 19:25
 *
 * @author crwen
 * @create 2020-03-09-19:25
 * @since JDK 1.8
 */
public class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length < 2)
            return new int[]{};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        return new int[]{};
    }
}
