
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: Solution3
 * Description:
 * date: 2020/3/9 19:42
 *
 * @author crwen
 * @create 2020-03-09-19:42
 * @since JDK 1.8
 */
public class Solution3 {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length < 2)
            return new int[]{};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]))
                return new int[] {map.get(target - nums[i]), i};
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
