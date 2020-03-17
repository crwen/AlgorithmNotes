
class Solution {

    private int[] memo;

    public int rob(int[] nums) {
        memo = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            memo[i] = -1;
        return tryRob(nums, 0);
    }

    // 尝试偷取 [index...n-1]
    private int tryRob(int[] nums, int index) {
        if (index >= nums.length)
            return 0;

        if (memo[index] != -1)
            return memo[index];
            
        int res = 0;
        for (int i = index; i < nums.length; i++) {
            res = Math.max(res, nums[i] + tryRob(nums, i + 2));
        }
        memo[index] = res;

        return res;
    }
}