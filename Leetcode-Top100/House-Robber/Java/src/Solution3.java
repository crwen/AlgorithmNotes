
/**
 * ClassName: Solution3
 * Description:
 * date: 2020/3/17 15:51
 *
 * @author crwen
 * @create 2020-03-17-15:51
 * @since JDK 1.8
 */
class Solution3 {

    private int[] memo;

    public int rob(int[] nums) {
        memo = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            memo[i] = -1;
        return tryRob(nums, nums.length - 1);
    }

    // 尝试偷取 [0...index]
    public int tryRob(int[] nums, int index) {
        if (index < 0)
            return 0;

        if (memo[index] != -1)
            return memo[index];

        int res = 0;
        for (int i = index; i >= 0; i --) {
            res = Math.max(res, nums[i] + tryRob(nums, i - 2));
        }
        memo[index] = res;
        return res;
    }
}