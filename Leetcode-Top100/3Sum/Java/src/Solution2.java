
import java.util.*;

/**
 * ClassName: Solution2
 * Description:
 * date: 2020/3/9 16:39
 *
 * @author crwen
 * @create 2020-03-09-16:39
 * @since JDK 1.8
 */
public class Solution2 {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        if (nums.length < 3)
            return Collections.emptyList();
        Arrays.sort(nums);

        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0)
                break;
            int i = k + 1;
            int j = nums.length - 1;
            while (i < j) {
                if (nums[k] > 0 || nums[j] < 0)
                    break;
                int sum = nums[k] + nums[i] + nums[j];
                if (sum == 0) {
                    set.add(Arrays.asList(nums[k], nums[i++], nums[j--]));
                } else if (sum < 0) {
                    i ++;
                } else {
                    j --;
                }
            }
        }
        return new ArrayList<>(set);
    }


}
