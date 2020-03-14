
/**
 * ClassName: Solution2
 * Description:
 * date: 2020/3/14 22:59
 *
 * @author crwen
 * @create 2020-03-14-22:59
 * @since JDK 1.8
 */
public class Solution2 {
    public int singleNumber(int[] nums) {
        int ret = 0;
        for (int num : nums) {
            ret ^= num;
        }
        return ret;
    }
}
