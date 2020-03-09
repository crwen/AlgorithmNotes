
import java.util.*;

/**
 * ClassName: Solution
 * Description:
 * date: 2020/3/9 16:00
 *
 * @author crwen
 * @create 2020-03-09-16:00
 * @since JDK 1.8
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        if (nums.length < 3)
            return new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0)
                        set.add(Arrays.asList(nums[i], nums[j], nums[k]));
                }
            }
        }

        return new ArrayList<>(set);
    }

    public int binarySearch(int[] nums, int low, int high, int target) {
        // [low...high] 寻找 target
        if (low > high)
            return -1;
        while (low <= high) { // [low,low] 依然有效
            int mid = (high - low) / 2 + low;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target) { // 到 [low...mid-1] 中寻找
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.threeSum(nums);
        System.out.println(lists);
    }
}
