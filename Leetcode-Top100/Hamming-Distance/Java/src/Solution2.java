
/**
 * ClassName: Solution
 * Description:
 * date: 2020/3/14 14:53
 *
 * @author crwen
 * @create 2020-03-14-14:53
 * @since JDK 1.8
 */
public class Solution2 {
    public int hammingDistance(int x, int y) {
        int res = x ^ y;
        int ret = 0;
        while (res > 0) {
            if ( (res & 1) == 1 ) {
                ret ++;
            }
            res >>= 1;
        }
        return ret;
    }
}
