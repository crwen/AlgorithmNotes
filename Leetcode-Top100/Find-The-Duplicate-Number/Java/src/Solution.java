
import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: Solution
 * Description:
 * date: 2020/3/16 14:34
 *
 * @author crwen
 * @create 2020-03-16-14:34
 * @since JDK 1.8
 */
public class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i]))
                return nums[i];
            set.add(nums[i]);
        }
        return -1;
    }
}
