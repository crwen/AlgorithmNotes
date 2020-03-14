
import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: Solution
 * Description:
 * date: 2020/3/14 22:58
 *
 * @author crwen
 * @create 2020-03-14-22:58
 * @since JDK 1.8
 */
public class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i]))
                set.add(nums[i]);
            else
                set.remove(nums[i]);
        }
        int ret = 0;
        for ( Integer integer : set) {
            ret = integer;
        }
        return ret;
    }
}
