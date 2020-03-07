//
// Created by crwen on 2020/3/7.
//
#include <vector>
#include <iostream>

using namespace std;
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

int main() {

    int arr[] = {0, 1, 0, 3, 12};
    vector<int> vec(arr, arr + sizeof(arr) / sizeof(int));

    Solution().moveZeroes(vec);

    for (int i = 0; i < vec.size(); ++i) {
        cout << vec[i] << " ";
    }
    return 0;
}