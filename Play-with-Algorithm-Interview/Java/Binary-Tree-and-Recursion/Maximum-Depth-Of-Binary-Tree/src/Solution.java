
/**
 * ClassName: Solution
 * Description:
 * date: 2020/3/14 16:50
 *
 * @author crwen
 * @create 2020-03-14-16:50
 * @since JDK 1.8
 */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
