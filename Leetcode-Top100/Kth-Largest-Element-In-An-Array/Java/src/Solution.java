
import java.util.Arrays;

/**
 * ClassName: Solution
 * Description:
 * date: 2020/3/13 12:25
 *
 * @author crwen
 * @create 2020-03-13-12:25
 * @since JDK 1.8
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums.length < k)
            throw new IllegalArgumentException("argument is illegal");
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
