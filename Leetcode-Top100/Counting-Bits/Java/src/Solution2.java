
/**
 * ClassName: Solution2
 * Description:
 * date: 2020/3/17 22:56
 *
 * @author crwen
 * @create 2020-03-17-22:56
 * @since JDK 1.8
 */
public class Solution2 {

    public int[] countBits(int num) {
        int res[] = new int[num+1];
        res[0] = 0;
        for (int i = 0; i <= num; i++) {
            res[i] = res[i&(i-1)];
        }
        return res;
    }
}
