
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: Solution
 * Description:
 * date: 2020/3/24 16:27
 *
 * @author crwen
 * @create 2020-03-24-16:27
 * @since JDK 1.8
 */
public class Solution {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length / 2);
        for (int x : nums)
            map.put(x, map.getOrDefault(x, 0) + 1);
        int max = 0;
        int res = nums[0];
        for (int key : map.keySet()) {
            int count = map.get(key);
            if (count > nums.length / 2)
                return key;
            //if (max < count) {
            //    max = count;
            //    res = key;
            //}
        }
        //return res;
        return -1;
    }

    public int majorityElement2(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();
        // 遍历每个数统计次数
        for (int num: nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
            // 如果某个数次数超过了n/2就返回
            if (counter.get(num) > nums.length / 2) {
                return num;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        //int[] nums = {3,2,3};
        int[] nums = {6,5,5};
        Solution solution = new Solution();
        System.out.println(solution.majorityElement(nums));
    }
}
