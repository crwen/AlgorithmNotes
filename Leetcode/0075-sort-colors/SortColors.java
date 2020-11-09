//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 注意: 
//不能使用代码库中的排序函数来解决这道题。 
//
// 示例: 
//
// 输入: [2,0,2,1,1,0]
//输出: [0,0,1,1,2,2] 
//
// 进阶： 
//
// 
// 一个直观的解决方案是使用计数排序的两趟扫描算法。 
// 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
// Related Topics 排序 数组 双指针 
// 👍 691 👎 0

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 1. 桶排序/计数排序
    // 2. 三路快排、荷兰国旗问题
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0)
            throw new RuntimeException("array is null or is empty");
        partition(nums, 0, nums.length - 1, 1);
    }

    private void partition(int[] nums, int low, int high, int target) {
        if (low > high)
            throw new RuntimeException("low is greater than high");
        int less = low - 1;
        int more = high + 1;
        int cur = low;
        while (cur < more) {
            //System.out.println(Arrays.toString(nums));
            if (nums[cur] == target) {
                cur ++;
            } else if (nums[cur] < target) {
                swap(nums, cur++, ++less);
            } else {
                swap(nums, cur, -- more);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
