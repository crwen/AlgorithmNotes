
import java.util.Arrays;

/**
 * ClassName: Solution2
 * Description:
 * date: 2020/3/8 10:05
 *
 * @author crwen
 * @create 2020-03-08-10:05
 * @since JDK 1.8
 */
class Solution2 {
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

    public static void main(String[] args) {
        //int[] nums = {2,0,2,1,1,0};
        int[] nums = {0};
        Solution2 solution2 = new Solution2();
        solution2.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
