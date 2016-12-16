package recursion;

/**
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling
 * (a left node that shares the same parent node) or empty, flip it upside down and
 * turn it into a tree where the original right nodes turned into left leaf nodes.
 *
 * Return the new root.
 *
 * For example:
 * Given a binary tree {1,2,3,4,5},
 *
 *     1
 *    / \
 *   2   3
 *  / \
 * 4   5
 *
 * return the root of the binary tree [4,5,2,#,#,3,1].
 *    4
 *   / \
 *  5   2
 *     / \
 *    3   1
 *
 * [Source]     - {@linkplain https://leetcode.com/problems/binary-tree-upside-down/}
 * [Difficulty] - Medium
 *
 */
public class tr_recur_upside_down_binary_tree
{
    public static class TreeNode
    {
        int      val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x)
        {
            val = x;
        }
    }

    public TreeNode upsideDownBinaryTree(TreeNode root)
    {
        return recurse(root, null, null);
    }

    private TreeNode recurse(TreeNode c, TreeNode newLeft, TreeNode newRight)
    {
        TreeNode newNewLeft = c.right;
        TreeNode newNewRight = c;
        TreeNode next = c.left;
        c.left = newLeft;
        c.right = newRight;

        if (next != null) {
            return recurse(next, newNewLeft, newNewRight);
        } else {
            return c;
        }
    }

    public TreeNode upsideDownBinaryTreeIterative(TreeNode root) {
        TreeNode c = root;
        TreeNode newLeft = null;
        TreeNode newRight = null;
        TreeNode oldParent = null;

        while (c != null) {
            TreeNode newNewLeft = c.right;
            TreeNode newNewRight = c;
            TreeNode next = c.left;
            c.right = newRight;
            c.left = newLeft;
            newRight = newNewRight;
            newLeft = newNewLeft;
            oldParent = c;
            c = next;
        }

        return oldParent;
    }
}
