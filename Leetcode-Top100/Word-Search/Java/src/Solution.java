
class Solution {
    
    private int[][] dir = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};

    private int m;

    private int n;

    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
       if(board == null || word == null)
            throw new IllegalArgumentException("board or word can not be null!");

        m = board.length;
        if(m == 0)
            throw new IllegalArgumentException("board can not be empty.");
        n = board[0].length;
        if(n == 0)
            throw new IllegalArgumentException("board can not be empty.");
            
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //if (!visited[i][j]) {
                    if (searchWord(board, word, i, j, 0)) {
                        return true;
                    //}
                }
            }
        }

        return false;
    }

    private boolean searchWord(char[][] board, String word, int x, int y, int index) {

        if (index == word.length() - 1) {
            return board[x][y] == word.charAt(index);
        }
        
        if (board[x][y] == word.charAt(index)) {
            visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int newX = x + dir[i][0];
                int newY = y + dir[i][1];
                if (checked(newX, newY) && !visited[newX][newY] && searchWord(board, word, newX, newY, index + 1)) {
                    return true;
                }
            }
            visited[x][y] = false;
        }

        return false;
    }

    private boolean checked(int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }
}