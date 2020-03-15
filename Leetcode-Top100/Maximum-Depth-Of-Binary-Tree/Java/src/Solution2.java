
import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName: Solution2
 * Description:
 * date: 2020/3/15 11:37
 *
 * @author crwen
 * @create 2020-03-15-11:37
 * @since JDK 1.8
 */
public class Solution2 {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        int max = 0;
        queue.add(new Pair<>(root, 1));
        while (! queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            max = max > pair.getValue() ? max : pair.getValue();
            if (pair.getKey().left != null) {
                queue.add(new Pair<>(pair.getKey().left, pair.getValue() + 1));
            }
            if (pair.getKey().right != null) {
                queue.add(new Pair<>(pair.getKey().right, pair.getValue() + 1));
            }
        }
        return max;
    }
}
