
import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName: Solution2
 * Description:
 * date: 2020/3/14 19:01
 *
 * @author crwen
 * @create 2020-03-14-19:01
 * @since JDK 1.8
 */
public class Solution2 {
    public static boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        if (root.left == null && root.right == null)
            return true;
        if (root.left == null || root.right == null)
            return false;
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.add(root.left);
        q2.add(root.right);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode node1 = q1.poll();
            TreeNode node2 = q2.poll();
            if (node1 == null && node2 == null)
                continue;
            if (node1 == null || node2 == null)
                return false;
            if (node1.val != node2.val)
                return false;

            q1.add(node1.left);
            q1.add(node1.right);
            q2.add(node2.right);
            q2.add(node2.left);
        }
        if (!q1.isEmpty() || !q2.isEmpty())
            return false;

        return true;
    }

}
