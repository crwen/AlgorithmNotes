
/**
 * ClassName: Solution3
 * Description:
 * date: 2020/3/13 12:40
 *
 * @author crwen
 * @create 2020-03-13-12:40
 * @since JDK 1.8
 */
public class Solution3 {
    public int findKthLargest(int[] nums, int k) {
        if (nums.length < k)
            throw new IllegalArgumentException("argument is illegal");

        for (int i = (nums.length - 2) / 2; i >= 0 ; i--) {
            shiftDown(nums, i, nums.length);
        }

        int max = -1;
        int size = nums.length;
        for (int i = 0; i < k; i++) {
            max = nums[0];
            nums[0] = nums[size - 1];
            shiftDown(nums, 0, size--);
        }
        return max;
    }

    // 下浮
    public void shiftDown(int[] arr, int k, int size) {
        int v = arr[k];
        // k * 2 + 1 < size
        while ((k * 2 + 1) < size) {
            int j = k * 2 + 1; // 左孩子
            if ( j + 1 < size && arr[j] < arr[j + 1]) // 有孩子存在，且比左孩子大
                j += 1;
            if (arr[j] > v) {
                arr[k] = arr[j];
                k = j;
            } else {
                break;
            }
        }
        arr[k] = v;
    }
}
