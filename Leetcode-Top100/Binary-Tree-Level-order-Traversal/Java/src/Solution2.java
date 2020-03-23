
import java.util.*;

/**
 * ClassName: Solution2
 * Description:
 * date: 2020/3/15 15:00
 *
 * @author crwen
 * @create 2020-03-15-15:00
 * @since JDK 1.8
 */
public class Solution2 {

    class Pair<TreeNode, Integer> {
        TreeNode node;
        int level;
        public Pair(TreeNode node, int level) {
            this.level = level;
            this.node = node;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return Collections.emptyList();
        List<List<Integer>> res = new ArrayList<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();

        queue.add(new Pair<>(root, 0));
        while (!queue.isEmpty()) {

            Pair<TreeNode, Integer> pair = queue.poll();
            int level = pair.level; // 当前节点所在层
            TreeNode node = pair.node;

            if (level == res.size())
                res.add(new ArrayList<Integer>());

            res.get(level).add(node.val);

            if (node.left != null)
                queue.add(new Pair<>(node.left, level + 1));
            if (node.right != null)
                queue.add(new Pair<>(node.right, level +1));
        }

        return res;
    }
}
