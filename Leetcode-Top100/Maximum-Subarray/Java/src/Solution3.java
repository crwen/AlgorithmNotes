
/**
 * ClassName: Solution3
 * Description:
 * date: 2020/3/26 17:18
 *
 * @author crwen
 * @create 2020-03-26-17:18
 * @since JDK 1.8
 */
public class Solution3 {
    public int maxSubArray(int[] nums) {// 动态规划法
        int n = nums.length, maxSum = nums[0];
        for (int i = 0; i < n; i++) {
            if (nums[i-1] >0)
                nums[i] += nums[i-1];
            maxSum = Math.max(nums[i], maxSum);
        }
        return maxSum;
    }
}
