
/**
 * ClassName: Solution2
 * Description:
 * date: 2020/3/16 12:51
 *
 * @author crwen
 * @create 2020-03-16-12:51
 * @since JDK 1.8
 */
public class Solution3 {
    private int[] memo;

    private final int MAX = Integer.MAX_VALUE - 8;

    public int numSquares(int n) {
        memo = new int[n+1];
        for (int i = 0;i  < n + 1; i++)
            memo[i] = MAX;
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                memo[i] = min(i, 1 + memo[i - j * j], memo[i]);
            }
        }
        return memo[n];
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public static void main(String[] args) {
        Solution3 solution2 = new Solution3();
        System.out.println(solution2.numSquares(12));
    }
}
