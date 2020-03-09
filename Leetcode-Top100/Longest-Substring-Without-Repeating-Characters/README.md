
**[题目传送门](https://leetcode.com/problems/two-sum/)**

**题目描述**

给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。



**示例:**
```html
给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
```

**方法一**

暴力出奇迹。两重循环，找出所有相加的可能。

时间复杂度 O(n)

空间复杂度 O(1)

```java
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length < 2)
            return new int[]{};

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        }

        return new int[]{};
    }
}
```

**方法二**

利用 hash table，可以达到 O(1) 的查找。我们将数组元素作为 key，将索引作为 value，考虑到数组中可能有重复元素，所以判断的时候要多一层判断

```java
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length < 2)
            return new int[]{};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if (map.containsKey(tmp) && map.get(tmp) != i){ // 考虑到有重复元素，所以要求 map.get(tmp) != i
                return new int[] { i, map.get(tmp) };
            }
        }
        return new int[]{};
    }
}
```

如果不能理解判断那一块，可以在将元素添加进 map 之前判断此时 map 中是否存在满足条件的元素。其实这样效率更高

```java
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length < 2)
            return new int[]{};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]))
                return new int[] {map.get(target - nums[i]), i};
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
```