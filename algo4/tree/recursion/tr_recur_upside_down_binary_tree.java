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
    public class TreeNode
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
        return recurse(root, null);
    }

    private TreeNode recurse(TreeNode c, TreeNode parent)
    {
        if (c == null) {
            return null;
        }

        TreeNode root = recurse(c.left, c);

        c.left = parent == null ? null : parent.right;
        c.right = parent;

        return root == null ? c : root;
    }

    public TreeNode upsideDownBinaryTreeNonRecur(TreeNode root)
    {
        TreeNode parentRight = null, parent = null, c = root;

        while (c != null) {
            TreeNode newParentRight = c.right, newParent = c, next = c.left;
            c.left = parentRight;
            c.right = parent;
            parentRight = newParentRight;
            parent = newParent;
            c = next;
        }

        return parent;
    }
}
