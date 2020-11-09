//给定一组非负整数 nums，重新排列它们每位数字的顺序使之组成一个最大的整数。 
//
// 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [10,2]
//输出："210" 
//
// 示例 2： 
//
// 输入：nums = [3,30,34,5,9]
//输出："9534330"
// 
//
// 示例 3： 
//
// 输入：nums = [1]
//输出："1"
// 
//
// 示例 4： 
//
// 输入：nums = [10]
//输出："10"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 109 
// 
// Related Topics 排序 
// 👍 416 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            throw new RuntimeException("array is null or empty");
        String[] arr = new String[nums.length];
        for (int i = 0; i < arr.length; i ++) {
            arr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(arr, (a, b) -> {
            return (b + a).compareTo(a + b);
        });
        if (arr[0].equals("0"))
            return "0";
        StringBuffer sb = new StringBuffer();
        for (String s : arr) {
            sb.append(s);
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
