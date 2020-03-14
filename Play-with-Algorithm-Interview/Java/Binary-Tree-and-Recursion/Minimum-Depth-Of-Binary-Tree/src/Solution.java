
/**
 * ClassName: Solution
 * Description:
 * date: 2020/3/14 17:05
 *
 * @author crwen
 * @create 2020-03-14-17:05
 * @since JDK 1.8
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        int right =  minDepth(root.right);
        int left =  minDepth(root.left);
        if (left == 0 || right == 0)
            return left + right + 1;
        return Math.min(left, right) + 1;
    }
}
