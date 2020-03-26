
/**
 * ClassName: Solution2
 * Description:
 * date: 2020/3/26 16:31
 *
 * @author crwen
 * @create 2020-03-26-16:31
 * @since JDK 1.8
 */
public class Solution2 {
    private int[][] memo;

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }
        return minPathSum(grid, 0, 0);

    }

    private int minPathSum(int[][] grid, int x, int y) {
        if (x == grid.length || y == grid[0].length)
            return Integer.MAX_VALUE;
        if (x == grid.length - 1 && y == grid[0].length - 1) {
            return grid[x][y];
        }

        if (memo[x][y] != -1)
            return memo[x][y];
        int a = minPathSum(grid, x + 1, y);
        int b = minPathSum(grid, x , y + 1);
        int res = grid[x][y] +  Math.min(a, b);
        memo[x][y] = res;
        return res;
    }
}
