
/**
 * ClassName: mergetwobinarytrees.mergetwobinarytrees
 * Description:
 * date: 2020/3/14 20:46
 *
 * @author crwen
 * @create 2020-03-14-20:46
 * @since JDK 1.8
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }


}
