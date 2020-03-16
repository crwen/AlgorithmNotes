
/**
 * ClassName: Solution2
 * Description:
 * date: 2020/3/16 12:51
 *
 * @author crwen
 * @create 2020-03-16-12:51
 * @since JDK 1.8
 */
public class Solution2 {
    private int[] memo;

    private final int MAX = Integer.MAX_VALUE - 8;

    public int numSquares(int n) {
        memo = new int[n+1];
        for (int i = 0;i  < n + 1; i++)
            memo[i] = MAX;

        return find(n);
    }

    private int find(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1)
            return 1;

        for (int i = 1; i * i <= n; i++) {
            if (memo[n-i*i] < MAX) {
                memo[n] = min(n, 1 + memo[n-i*i], memo[n]);
            } else {
                memo[n] = min(n, 1 + find(n - i * i) , memo[n]);
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
