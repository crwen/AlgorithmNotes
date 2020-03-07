
/**
 * ClassName: Solution
 * Description:
 * date: 2020/3/7 20:29
 *
 * @author crwen
 * @create 2020-03-07-20:29
 * @since JDK 1.8
 */
public class Solution {
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
}
