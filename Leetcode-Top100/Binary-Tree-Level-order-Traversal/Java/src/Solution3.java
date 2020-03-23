
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Solution3
 * Description:
 * date: 2020/3/15 15:20
 *
 * @author crwen
 * @create 2020-03-15-15:20
 * @since JDK 1.8
 */
public class Solution3 {
    List<List<Integer>> levels = new ArrayList<List<Integer>>();

    public void helper(TreeNode node, int level) {

        if (levels.size() == level)
            levels.add(new ArrayList<Integer>());

        levels.get(level).add(node.val);

        if (node.left != null)
            helper(node.left, level + 1);
        if (node.right != null)
            helper(node.right, level + 1);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return levels;
        helper(root, 0);

        return levels;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4 , 5, 6, 7};
        TreeNode root = new TreeNode(1);
        TreeNode build = build(root, nums, 0);
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.levelOrder(build));
    }


    static TreeNode build(TreeNode node, int[] nums, int i) {
        node = new TreeNode(nums[i]);
        if (i * 2 + 1 < nums.length)
            node.left = build(node.left, nums, i * 2 + 1);
        if (i * 2 + 2 < nums.length)
            node.right = build(node.right, nums, i * 2 + 2);

        return node;
    }

}
