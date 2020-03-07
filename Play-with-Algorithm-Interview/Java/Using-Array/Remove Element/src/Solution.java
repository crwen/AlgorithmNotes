
import java.util.Arrays;

/**
 * ClassName: Solution
 * Description:
 * date: 2020/3/7 21:26
 *
 * @author crwen
 * @create 2020-03-07-21:26
 * @since JDK 1.8
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        int[] arr = new int[nums.length];

        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                arr[k++] = nums[i];
            }
        }
        System.arraycopy(arr, 0, nums, 0, k);
        return k;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        Solution solution = new Solution();
        int res = solution.removeElement(nums, val);
        System.out.println(Arrays.toString(nums));
        System.out.println(res);
    }
}
