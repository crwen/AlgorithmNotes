
**[题目传送门](https://leetcode.com/problems/sort-colors/)**

**题目描述**

给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

注意:
不能使用代码库中的排序函数来解决这道题。

**示例:**
```html
输入: [2,0,2,1,1,0]
输出: [0,0,1,1,2,2]
```

**方法一**

使用排序算法将数组中元素排序


时间复杂度 O(nlgn)

空间复杂度 O(nlgn)

**方法二**

由于数组中只有 0、1、2，所以我们可以分别计算出数组中 0、1、2 元素的个数，然后再写入数组。

时间复杂度 O(n)

空间复杂度 O(1)

```java
class Solution {
    public void sortColors(int[] nums) {
        if (nums.length < 2)
            return;
        int[] count = {0, 0, 0};
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        int k = 0;
        for (int i = 0; i < count.length; i++ ) {
            for (int j = 0; j < count[i]; j++) {
                nums[k++] = i;
            }
        }
    }
}
```

**方法三**

定义三个指针 i, j, k，i 指向第一个非 0 元素，即 [0...i-1] 中的元素全为 0；j 指向最后一个非 2 元素，即 [j+1...size-1] 中元素全为 2，k 用来遍历。此方法与三路快排的 partition 操作相同。

时间复杂度 O(n)

空间复杂度 O(1)

```java
public class Solution3 {
    public void sortColors(int[] nums) {
        int i = 0; // [0...i-1] 元素全为 0
        int j = nums.length - 1; // [j + 1...size - 1] 全为 2

        for (int k = 0; k <= j;) {
            if (nums[k] == 1) {
                k++;
            } else if (nums[k] == 0) {
                swap(nums, k++, i++);
            } else if (nums[k] == 2) {
                swap(nums, k, j--);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
```