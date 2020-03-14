
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: Solution3
 * Description:
 * date: 2020/3/14 15:21
 *
 * @author crwen
 * @create 2020-03-14-15:21
 * @since JDK 1.8
 */
public class Solution3 {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            int newIndex = Math.abs(nums[i]) - 1;

            if (nums[newIndex] > 0) {
                nums[newIndex] *= -1;
            }
        }

        List<Integer> result = new LinkedList<Integer>();
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] > 0) {
                result.add(i);
            }
        }

        return result;
    }
}
