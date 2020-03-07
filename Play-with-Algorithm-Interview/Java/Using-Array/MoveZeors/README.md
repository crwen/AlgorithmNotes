
**[题目传送门](https://leetcode.com/problems/move-zeroes/)**

**题目描述**

给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。。

**示例**
```html
输入: [0,1,0,3,12]
输出: [1,3,12,0,0]
```

**方法一**

新开一个数组，将非零元素放入新数组中，然后复制回去，尾部 补 0

时间复杂度 O(n)

空间复杂度 O(n)

```java
    public void moveZeroes(int[] nums) {
        int[] arr = new int[nums.length];

        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                arr[k++] = nums[i];
            }
        }
        
        for (int i = 0; i < k; i++) {
            nums[i] = arr[i];
        }
        
        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
```

**方法二**

定义两个指针，第一个指针指向第一个 0 元素，第二个指针遍历数组，遇到非零元素，向前移

时间复杂度 O(n)

空间复杂度 O(1)

![image](./../../../asset/move_zeros1.gif)

```java
public class Solution {
    public void moveZeroes(int[] nums) {
        int k = 0; //指向第一个非零元素

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k++] = nums[i];
            }
        }
        for (int i = k; i <nums.length; i++) {
            nums[i] = 0;
        }
    }
}
```

**方法三**

思路与方法二类似，只不过遇到非零元素的处理方式不同而已。遇到非零元素是，我们直接交换两个指针对应元素。

时间复杂度 O(n)

空间复杂度 O(1)

![image](./../../../asset/move_zeros2.gif)


```java
public class Solution {
    public void moveZeroes(int[] nums) {
        int k = 0; //指向第一个非零元素

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, k++, i);
            }
        }
    }
    
    public void swap(int arr[], int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
```