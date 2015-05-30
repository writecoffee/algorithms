/**
 * Given a binary tree, find the largest subtree which is a Binary Search Tree (BST),
 * where largest means subtree with largest number of nodes in it.
 *
 * Note:
 *
 * A subtree must include all of its descendants.
 *
 * Here's an example:
 *
 *     10
 *     / \
 *    5  15
 *   / \   \
 *  1   8   7
 *
 * The Largest BST Subtree in this case is the highlighted one.
 *
 * The return value is the subtree's size, which is 3.
 *
 * [Difficulty] - Hard
 * [Source]     - {@linkplain https://leetcode.com/problems/largest-bst-subtree/}
 *
 */
public class tree_largest_bst_subtree
{
    public class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int largestBSTSubtree(TreeNode root)
    {
        if (root == null) {
            return 0;
        }

        int[] result = new int[1];
        explore(root, result);
        return result[0];
    }

    /**
     * There could be a problem if we constrain the boundary in a top-down manner.
     *
     * e.g.
     *
     *      3
     *     /
     *   1
     *  /
     * 2
     *  \
     *   4
     *
     * Thus, we need to calculate it in a bottom-up manner by propagating the left,
     * right boundary.
     *
     */
    private int[] explore(TreeNode c, int[] result)
    {
        int[] lresult = new int[] { 0, Integer.MIN_VALUE, c.val };
        int[] rresult = new int[] { 0, c.val, Integer.MAX_VALUE };

        if (c.left != null) {
            lresult = explore(c.left, result);
        }

        if (c.right != null) {
            rresult = explore(c.right, result);
        }

        if (lresult[0] < 0 || rresult[0] < 0 || c.val < lresult[2] || c.val > rresult[1]) {
            return new int[] { -1, 0, 0 };
        }

        int sum = lresult[0] + rresult[0] + 1;
        result[0] = Math.max(result[0], sum);
        return new int[] { sum, (c.left == null ? c.val : lresult[1]), (c.right == null ? c.val : rresult[2]) };
    }
}
