package recursion;

/**
 * Given a binary tree, find its minimum depth.
 * 
 * The minimum depth is the number of nodes along the shortest path from the root node down to the
 * nearest leaf node.
 * 
 * The additional constrain is that we should use recursion to solve this.
 * 
 * What's the time complexity? O(n), since all node have to be explored once.
 * 
 * [Difficulty] - Easy
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/minimum-depth-of-binary-tree/}
 * 
 */
public class tr_recur_minimum_depth {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        } else if (root.left == null) {
            return 1 + minDepth(root.right);
        } else if (root.right == null) {
            return 1 + minDepth(root.left);
        } else {
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        }
    }
}