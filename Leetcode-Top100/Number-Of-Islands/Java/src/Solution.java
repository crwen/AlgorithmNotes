
class Solution {

    private int m, n;
    private int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private boolean visited[][];
    
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        m = grid.length; // 行
        n = grid[0].length; // 列
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                visited[i][j] = false;
        int res = 0;
        for (int i = 0;  i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, i, j);
                    res ++;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int x, int y) {
        
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + dir[i][0];
            int newY = y + dir[i][1];
            if (check(newX, newY) && !visited[newX][newY] && grid[newX][newY] == '1') {
                dfs(grid, newX, newY);
            }
            
        }
        return ;
    }

    private boolean check(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}