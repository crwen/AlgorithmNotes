//给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是 nums[i] 右侧小于 num
//s[i] 的元素的数量。 
//
// 
//
// 示例： 
//
// 输入：nums = [5,2,6,1]
//输出：[2,1,1,0] 
//解释：
//5 的右侧有 2 个更小的元素 (2 和 1)
//2 的右侧仅有 1 个更小的元素 (1)
//6 的右侧有 1 个更小的元素 (1)
//1 的右侧有 0 个更小的元素
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10^5 
// -10^4 <= nums[i] <= 10^4 
// 
// Related Topics 排序 树状数组 线段树 二分查找 分治算法 
// 👍 473 👎 0

import java.util.ArrayList;
import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
// 1. 暴力，O(n^2)

class Solution {

    private List<Integer> res = new ArrayList<>();

    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0)
            return res;
        for (int i = 0; i < nums.length; i++) {
            res.add(0);
        }
        countSmaller(nums, 0, nums.length - 1);
        return res;
    }

    private void countSmaller(int[] nums, int low, int high) {
        if (low >= high)
            return;
        int mid = (high - low) / 2 + low;
        countSmaller(nums, low, mid);
        countSmaller(nums, mid + 1, high);
        merge(nums, low, mid, high);
    }


    private void merge(int[] nums, int low, int mid, int high) {
        if (low > high)
            throw new RuntimeException("args is illegal");
        int[] arr = new int[high - low + 1];
        //for (int i = low; i <= high; i++) {
        //    arr[i - low] = nums[low];
        //}
        int i = low;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= high) {
            if (nums[i] > nums[j]) {
                res.set(i, res.get(i) + (high - j + 1));
                arr[k++] = nums[i++];
            } else {
                arr[k++] = nums[j++];
            }
        }
        while (i <= mid) arr[k ++] = nums[i++];
        while (j <= high) arr[k ++] = nums[j++];
        for (int l = 0; l < arr.length; l++) {
            nums[l + low] = arr[l];
        }

    }

}
//leetcode submit region end(Prohibit modification and deletion)
