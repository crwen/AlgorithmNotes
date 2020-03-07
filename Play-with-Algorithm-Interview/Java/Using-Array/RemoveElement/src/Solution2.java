package removeelement;

/**
 * ClassName: Solution2
 * Description:
 * date: 2020/3/7 21:36
 *
 * @author crwen
 * @create 2020-03-07-21:36
 * @since JDK 1.8
 */
public class Solution2 {
    public int removeElement(int[] nums, int val) {
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }
}
