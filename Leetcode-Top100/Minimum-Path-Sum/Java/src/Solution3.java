
/**
 * ClassName: Solution3
 * Description:
 * date: 2020/3/26 16:31
 *
 * @author crwen
 * @create 2020-03-26-16:31
 * @since JDK 1.8
 */
public class Solution3 {
    private int[][] memo;

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        memo = new int[m][n];

        memo[0][0] = grid[0][0];
        for (int i = 1; i < m; i++)
            memo[i][0] = memo[i-1][0] + grid[i][0];
        for (int i = 1; i < n; i++) {
            memo[0][i] = memo[0][i-1] + grid[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                memo[i][j] = grid[i][j] + Math.min(memo[i][j-1], memo[i-1][j]);
            }
        }

        return memo[m-1][n-1];
    }
}
