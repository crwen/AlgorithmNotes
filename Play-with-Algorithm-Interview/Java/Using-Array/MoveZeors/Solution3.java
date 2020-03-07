package movezeros;

/**
 * ClassName: Solution3
 * Description:
 * date: 2020/3/7 20:51
 *
 * @author crwen
 * @create 2020-03-07-20:51
 * @since JDK 1.8
 */
public class Solution3 {
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
