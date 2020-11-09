//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表 
// 👍 9523 👎 0

import java.util.Map;0001-two-sum/TwoSum

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 1. 暴力 O(n^2)
    // 2. 排序，双指针, O(nlogn)
    // 3. hash
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            throw new RuntimeException("非法参数");

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }

        return new int[]{-1, -1};
    }
}
//leetcode submit region end(Prohibit modification and deletion)
