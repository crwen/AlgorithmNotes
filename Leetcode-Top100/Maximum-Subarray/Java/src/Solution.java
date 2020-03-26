
/**
 * ClassName: Solution
 * Description:
 * date: 2020/3/26 17:16
 *
 * @author crwen
 * @create 2020-03-26-17:16
 * @since JDK 1.8
 */
public class Solution {
    private int res;

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }
}
