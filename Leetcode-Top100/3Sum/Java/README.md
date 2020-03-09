
**[题目传送门](https://leetcode.com/problems/3sum/)**

**题目描述**

给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。


**示例:**
```html
给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]
```

**方法一**

先排序，然后暴力，三重循环，会超时

时间复杂度 O(n^3)

空间复杂度 O(1)

**方法二**

先排序，得到有序数组，于是我们可以想到二分查找，可以将时间复杂度优化到 O(n^2 * logn)

**方法三**

先排序，定义三个指针 `i`, `j`, `k`, k
 用来遍历，然后 i，j 的初始值分别位 `k + 1`, `len - 1`，然后移动 `i`, `j`，寻找 能够使 `nums[k] + nums[i] + nums[j] = 0` 的组合。具体规则如下：
 - `nums[k] + nums[i] + nums[j] > 0` 说明，我们需要让 `nums[i] + nums[j] = 0`的值更小一点，只需要 `j--`
  - `nums[k] + nums[i] + nums[j] < 0` 说明，我们需要让 `nums[i] + nums[j] = 0`的值更大一点，只需要 `i++`
   - `nums[k] + nums[i] + nums[j] = 0` ，添加

   ```java
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3)
            return Collections.emptyList();
        Arrays.sort(nums);

        Set<List<Integer>> set = new HashSet<>();
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0)
                break;
            int i = k + 1;
            int j = nums.length - 1;
            while (i < j) {
                if (nums[k] > 0 || nums[j] < 0)
                    break;
                int sum = nums[k] + nums[i] + nums[j];
                if (sum == 0) {
                    set.add(Arrays.asList(nums[k], nums[i++], nums[j--]));
                } else if (sum < 0) {
                    i ++;
                } else {
                    j --;
                }
            }
        }
        return new ArrayList<>(set);
    }

}
   ```