package recursion;

/**
 * Given a binary tree, find the maximum path sum.
 * 
 * The path may start and end at any node in the tree.
 * 
 * For example:
 * 
 * Given the below binary tree,
 * 
 *        1
 *       / \
 *      2   3
 * 
 * Return 6.
 * 
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/binary-tree-maximum-path-sum/}
 *
 */
public class tr_recur_maximum_path_sum_for_binary_tree_I {
    public class TreeNode {
        public final int val;
        public final TreeNode left;
        public final TreeNode right;

        TreeNode(int _v, TreeNode _left, TreeNode _right) {
            val = _v;
            left = _left;
            right = _right;
        }
    }

    private int gMax;

    /**
     * LMAX(c) = max(c, c + LMAX(c.left), c + LMAX(c.right))
     * GMAX(c) = max(LMAX(c), c + LMAX(c.left) + LMAX(c.right))
     * 
     */
    public int maxPathSum(TreeNode root) {
        gMax = Integer.MIN_VALUE;
        explore(root);
        return gMax;
    }

    private int explore(TreeNode c) {
        if (c == null) {
            return 0;
        }

        int l = Math.max(0, explore(c.left));
        int r = Math.max(0, explore(c.right));
        int lMax = Math.max(c.val + l, c.val + r);
        gMax = Math.max(gMax, c.val + l + r);
        return lMax;
    }
}