package recursion;

import java.util.HashMap;

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
 * The additional requirement here is that we cannot use global variable.
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/binary-tree-maximum-path-sum/}
 *
 */
public class tr_recur_maximum_path_sum_for_binary_tree_II
{
    public class TreeNode
    {
        public final int      val;
        public final TreeNode left;
        public final TreeNode right;

        TreeNode(int _v, TreeNode _left, TreeNode _right)
        {
            val = _v;
            left = _left;
            right = _right;
        }
    }

    /**
     * LMAX(c) = max(c, c + LMAX(c.left), c + LMAX(c.right))
     * GMAX(c) = max(LMAX(c), c + LMAX(c.left) + LMAX(c.right))
     *
     */
    public int maxPathSum(TreeNode root)
    {
        HashMap<TreeNode, Integer> h = new HashMap<TreeNode, Integer>();
        h.put(null, Integer.MIN_VALUE);
        explore(root, h);
        return h.get(root);
    }

    private int explore(TreeNode c, HashMap<TreeNode, Integer> h)
    {
        if (c == null) {
            return 0;
        }

        int l = Math.max(0, explore(c.left, h));
        int r = Math.max(0, explore(c.right, h));
        int lMax = c.val + Math.max(l, r);
        h.put(c, Math.max(c.val + l + r, Math.max(h.get(c.left), h.get(c.right))));
        return lMax;
    }
}
