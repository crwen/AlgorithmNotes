
/**
 * ClassName: Solution4
 * Description:
 * date: 2020/3/17 15:52
 *
 * @author crwen
 * @create 2020-03-17-15:52
 * @since JDK 1.8
 */
class Solution4 {

    private int[] memo;

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        memo = new int[nums.length];
        memo[0] = nums[0];
        // 尝试偷取 [0...i]
        for(int i = 1 ; i < n ; i ++)
            for (int j = i; j >= 0; j--)
                memo[i] = Math.max(memo[i],
                        nums[j] + (j - 2 >= 0 ? memo[j - 2] : 0));
        return memo[n-1];
    }
}