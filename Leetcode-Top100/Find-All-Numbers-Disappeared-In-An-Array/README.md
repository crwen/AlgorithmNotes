
**[题目传送门](https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)**

**题目描述**

给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。

找到所有在 [1, n] 范围之间没有出现在数组中的数字。

您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。


**示例:**
```html
输入:
[4,3,2,7,8,2,3,1]

输出:
[5,6]
```

**方法一**

利用桶排序的思想，额外申请一个数组空间，将数组中元素与桶中元素做好对应关系就行了。

时间复杂度 O(n)

空间复杂度 O(n)

```java
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] bucket = new int[nums.length + 1];
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            bucket[nums[i]] = 1;
        }

        for (int i = 1; i <= nums.length; i++) {
            if (bucket[i] != 1)
                list.add(i);
        }

        return list;        
    }
}
```

**方法二**
仔细想想，这题就是鸽巢原理。将 n 个鸽子放入 n - 1 个笼子，至少有一个笼子有 2 个及以上的鸽子。

对于 `1 <= nums[i] <= n`，我们只需要将这个数字放到正确的位置上。这里就有一个问题了，就是这个数字覆盖的元素该怎么处理呢？一个办法是我们不进行覆盖，而是将对应位置的元素变为相反数，等到再次去到对应位置元素是只需要取绝对值就好了。最后遍历数组，大于 0 的数就是缺失的数

```java
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1; 
            if (nums[index] > 0)
                nums[index] *= -1; 
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i-1] > 0)
                list.add(i);
        }
        return list;
    }
```