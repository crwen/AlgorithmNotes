
/**
 * ClassName: Solution2
 * Description:
 * date: 2020/3/7 21:36
 *
 * @author crwen
 * @create 2020-03-07-21:36
 * @since JDK 1.8
 */
public class Solution3 {

    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else {
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {

    }
}
