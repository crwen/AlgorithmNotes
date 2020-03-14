
import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName: Solution3
 * Description:
 * date: 2020/3/14 19:36
 *
 * @author crwen
 * @create 2020-03-14-19:36
 * @since JDK 1.8
 */
public class Solution3 {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }

}
