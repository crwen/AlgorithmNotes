
import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName: Solution
 * Description:
 * date: 2020/3/15 16:15
 *
 * @author crwen
 * @create 2020-03-15-16:15
 * @since JDK 1.8
 */
public class Solution {
    public int numSquares(int n) {
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        visited[n] = true;
        queue.add(new Pair<>(n, 0));
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.poll();
            int num = pair.getKey();
            int step = pair.getValue();

            for (int i = 1; ; i++) {
                int a = num - i * i;
                if (a < 0)
                    break;
                if (a == 0)
                    return step + 1;

                if (!visited[a]) {
                    queue.add(new Pair<>(a, step + 1));
                    visited[a] = true;
                }
            }
        }
        return n;
    }
}
