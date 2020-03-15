
**[题目传送门](https://leetcode.com/problems/maximum-depth-of-binary-tree/)**

**题目描述**
给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

说明: 叶子节点是指没有子节点的节点。

**示例:**
给定二叉树 [3,9,20,null,null,15,7]，
```html
输入: [2,2,1]
输出: 1
```

**示例2:**
```html
    3
   / \
  9  20
    /  \
   15   7
```
返回它的最大深度 3 

**递归法**

```java
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
```

**迭代法**

bfs

```java
public class Solution {
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
```