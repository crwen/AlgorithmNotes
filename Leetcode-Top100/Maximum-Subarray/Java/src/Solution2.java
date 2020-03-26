
/**
 * ClassName: Solution2
 * Description:
 * date: 2020/3/26 17:16
 *
 * @author crwen
 * @create 2020-03-26-17:16
 * @since JDK 1.8
 */
public class Solution2 {
    private int max = Integer.MIN_VALUE;
    public int maxSubArray(int[] nums) {
        int sum;
        for (int i = 0; i < nums.length; i++) {// 子序列左端点
            sum = 0;
            for (int j = i; j < nums.length; j++) {// 子序列右端点
                sum += nums[j];// 这里就相当于每次根据前一次的序列来计算新的序列
                if (sum > max)
                    max = sum;
            }
        }
        return max;
    }
}
