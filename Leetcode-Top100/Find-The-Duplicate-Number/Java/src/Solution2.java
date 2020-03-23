
import java.util.Arrays;

/**
 * ClassName: Solution2
 * Description:
 * date: 2020/3/16 14:37
 *
 * @author crwen
 * @create 2020-03-16-14:37
 * @since JDK 1.8
 */
public class Solution2 {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1])
                return nums[i];
        }
        return -1;
    }
}
