
/**
 * ClassName: Solution
 * Description:
 * date: 2020/3/14 16:18
 *
 * @author crwen
 * @create 2020-03-14-16:18
 * @since JDK 1.8
 */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        getDepth(root);
        return ans - 1;
    }

    public int getDepth(TreeNode node) {
        if (node == null)
            return 0;
        int l = getDepth(node.left); // 左儿子为根的子树的深度
        int r = getDepth(node.right); // 右儿子为根的子树的深度
        ans = Math.max(ans, r + l + 1);
        return Math.max(r, l) + 1; // 返回以node为根的深度
    }

}
