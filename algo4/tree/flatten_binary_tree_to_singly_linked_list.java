import java.util.Stack;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * For example,
 *
 * Given
 *
 *         1
 *        / \
 *       2   5
 *      / \   \
 *     3   4   6
 *
 * The flattened tree should look like:
 *
 *   1
 *    \
 *     2
 *      \
 *       3
 *        \
 *         4
 *          \
 *           5
 *            \
 *             6
 *
 * [Source]     - {@linkplain https://leetcode.com/problems/flatten-binary-tree-to-linked-list/}
 * [Difficulty] - Medium
 *
 */
public class flatten_binary_tree_to_singly_linked_list
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

    public void flatten(TreeNode root)
    {
        if (root == null) {
            return;
        }

        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode psudoHead = new TreeNode(-1);
        TreeNode pre = psudoHead;
        s.push(root);

        while (!s.isEmpty()) {
            TreeNode c = s.pop();

            pre.left = null;
            pre.right = c;
            pre = c;

            if (c.right != null) {
                s.push(c.right);
            }

            if (c.left != null) {
                s.push(c.left);
            }
        }
    }

    public void flattenRecursive(TreeNode root)
    {
        if (root == null) {
            return;
        }

        explore(root);
    }

    private TreeNode explore(TreeNode c)
    {
        TreeNode deepmostLeft = null;
        TreeNode deepmostRight = null;

        if (c.left != null) {
            deepmostLeft = explore(c.left);
        }

        if (c.right != null) {
            deepmostRight = explore(c.right);
        }

        if (c.left != null) {
            deepmostLeft.left = null;
            deepmostLeft.right = c.right;
            c.right = c.left;
            c.left = null;
        }

        if (deepmostRight != null) {
            return deepmostRight;
        } else if (deepmostLeft != null) {
            return deepmostLeft;
        } else {
            return c;
        }
    }
}
