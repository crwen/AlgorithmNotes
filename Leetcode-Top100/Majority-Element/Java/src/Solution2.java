
import java.util.Arrays;

/**
 * ClassName: Solution2
 * Description:
 * date: 2020/3/24 16:47
 *
 * @author crwen
 * @create 2020-03-24-16:47
 * @since JDK 1.8
 */
public class Solution2 {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        Arrays.sort(nums);
        int max = 0;
        int res = nums[0];
        int j = 0, i = 0;
        for (; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                if (i - j > nums.length / 2)
                    return nums[j];
                if (max < (i - j)) {
                    max = i - j;
                    res = nums[j];
                }
                j = i;
            }
        }
        // if (nums[i-1] == nums[j] && max < (i - j)) {
        //     return nums[j];
        // }
        if (nums[i-1] == nums[j] && i - j > nums.length / 2) {
            return nums[j];
        }
        //return res;
        return -1;
    }
}
