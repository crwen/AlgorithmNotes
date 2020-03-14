
/**
 * ClassName: Solution
 * Description:
 * date: 2020/3/14 17:16
 *
 * @author crwen
 * @create 2020-03-14-17:16
 * @since JDK 1.8
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        invertTree(root.left);
        invertTree(root.right);
        TreeNode node = root.right;
        root.right = root.left;
        root.left = node;
        return root;
    }
}
