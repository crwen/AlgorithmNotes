
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

```c++
class Solution {
public:
    // 时间复杂度 O(n)
    // 空间复杂度 O(n)
    void moveZeroes(vector<int>& nums) {
        vector<int> nonZeroElements;

        for (int i = 0; i < nums.size(); ++i) {
            if (nums[i] != 0) {
                nonZeroElements.push_back( nums[i] );
            }
        }
        for (int i = 0; i < nonZeroElements.size(); ++i) {
            nums[i] = nonZeroElements[i];
        }

        for (int i = nonZeroElements.size(); i < nums.size(); ++i) {
            nums[i] = 0;
        }
    }
};
```

**方法二**

定义两个指针，第一个指针指向第一个 0 元素，第二个指针遍历数组，遇到非零元素，向前移

时间复杂度 O(n)

空间复杂度 O(1)

![image](./../../../asset/move_zeros1.gif)

```c++
class Solution {
public:
    // 时间复杂度 O(n)
    // 空间复杂度 O(1)
    void moveZeroes(vector<int>& nums) {

        int k = 0; // nums 中， [0...k] 的元素均为非 0 元素

        // 遍历到第 i 个元素后，保证 [0...i]中所有非0元素都按照顺序排列在 [0...k]中
        for (int i = 0; i < nums.size(); ++i) {
            if (nums[i] == 0) {
                nums[k++] = nums[i];
            }
        }

        // 将nums剩余位置放置为 0
        for (int i = k; i < nums.size(); ++i) {
            nums[i] = 0;
        }
    }
};
```

**方法三**

思路与方法二类似，只不过遇到非零元素的处理方式不同而已。遇到非零元素是，我们直接交换两个指针对应元素。

时间复杂度 O(n)

空间复杂度 O(1)

![image](./../../../asset/move_zeros2.gif)

```c++
class Solution {
public:
    // 时间复杂度 O(n)
    // 空间复杂度 O(1)
    void moveZeroes(vector<int>& nums) {

        int k = 0; // nums 中， [0...k] 的元素均为非 0 元素

        // 遍历到第 i 个元素后，保证 [0...i]中所有非0元素都按照顺序排列在 [0...k]中
        // 同时，[k...i] 为 0
        for (int i = 0; i < nums.size(); ++i) {
            if (nums[i] == 0) {
                swap(nums[k++], nums[i]);
            }
        }

        // 将nums剩余位置放置为 0
        for (int i = k; i < nums.size(); ++i) {
            nums[i] = 0;
        }
    }
};
```