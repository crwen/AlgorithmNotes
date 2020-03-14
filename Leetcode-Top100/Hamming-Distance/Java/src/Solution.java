
/**
 * ClassName: Solution2
 * Description:
 * date: 2020/3/14 14:54
 *
 * @author crwen
 * @create 2020-03-14-14:54
 * @since JDK 1.8
 */
public class Solution {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
