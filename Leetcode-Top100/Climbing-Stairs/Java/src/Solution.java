
/**
 * ClassName: Solution
 * Description:
 * date: 2020/3/16 14:18
 *
 * @author crwen
 * @create 2020-03-16-14:18
 * @since JDK 1.8
 */
public class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
