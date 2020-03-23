
/**
 * ClassName: Solution
 * Description:
 * date: 2020/3/23 19:20
 *
 * @author crwen
 * @create 2020-03-23-19:20
 * @since JDK 1.8
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int m = matrix.length; // 行
        int n = matrix[0].length; // 列
        int x = 0;
        int y = n - 1;

        while (x >= 0 && x < m && y >= 0 && y < n) {
            if (matrix[x][y] == target)
                return true;
            if (matrix[x][y] < target) {
                x ++;
            } else if (matrix[x][y] > target) {
                y --;
            }
        }
        return false;
    }
}
