
/**
 * ClassName: Solution3
 * Description:
 * date: 2020/3/14 14:56
 *
 * @author crwen
 * @create 2020-03-14-14:56
 * @since JDK 1.8
 */
public class Solution3 {
    public int hammingDistance(int x, int y) {
        int res = x ^ y;
        int ret = 0;
        while (res > 0) {
            ret ++;
            res &= (res - 1);
        }
        return ret;
    }
}
