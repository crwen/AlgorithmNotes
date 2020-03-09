
/**
 * ClassName: Solution
 * Description:
 * date: 2020/3/9 19:19
 *
 * @author crwen
 * @create 2020-03-09-19:19
 * @since JDK 1.8
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length < 2)
            return new int[]{};

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        }

        return new int[]{};
    }
}
