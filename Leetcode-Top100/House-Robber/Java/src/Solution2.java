
/**
 * ClassName: Solution2
 * Description:
 * date: 2020/3/17 15:24
 *
 * @author crwen
 * @create 2020-03-17-15:24
 * @since JDK 1.8
 */
class Solution2 {


    private int[] memo;

    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        int n = nums.length;

        memo = new int[n];
        memo[n-1] = nums[n-1];
        // 尝试偷取 [i...n-1]
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j < n - 2; j++) {
                memo[i] = Math.max(memo[i], nums[j] +  (j + 2 >= n ? 0 : memo[j+2]));
            }
        }
        return memo[0];
    }


}