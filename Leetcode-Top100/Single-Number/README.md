
**[题目传送门](https://leetcode.com/problems/single-number/)**

**题目描述**
给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

**说明：**

你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？



**示例:**
```html
输入: [2,2,1]
输出: 1
```

**示例2:**
```html
输入: [4,1,2,1,2]
输出: 4
```

**方法一**

```java
public class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i]))
                set.add(nums[i]);
            else
                set.remove(nums[i]);
        }
        int ret = 0;
        for ( Integer integer : set) {
            ret = integer;
        }
        return ret;
    }
}
```

**方法二**

由于除了一个元素只出现了一次外，其他元素都出现了两次，很容易想到异或。

> a ^ b = b ^ a
>
> a ^ b ^ c = a ^ (b ^ c) = (a ^ b) ^ c
>
>d = a ^ b ^ c 可以推出 a = d ^ b ^ c. 

```java
public class Solution {
    public int singleNumber(int[] nums) {
        int ret = 0;
        for (int num : nums) {
            ret ^= num;
        }

        return ret;
    }
}
```