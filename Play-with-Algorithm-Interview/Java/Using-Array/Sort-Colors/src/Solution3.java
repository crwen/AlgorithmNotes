
import java.util.Arrays;

/**
 * ClassName: Solution3
 * Description:
 * date: 2020/3/8 10:25
 *
 * @author crwen
 * @create 2020-03-08-10:25
 * @since JDK 1.8
 */
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

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        //int[] nums = {0};
        Solution2 solution2 = new Solution2();
        solution2.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
