package traversal;

/**
 * Given a binary search tree and a node in it, find the in-order successor of
 * that node in the BST.
 *
 * Note: If the given node has no in-order successor in the tree, return null.
 *
 * You are given PARENT pointer for each node.
 *
 * [Difficulty] - Easy
 * [Source]     - {CC150}
 *
 */
public class tr_trav_inorder_successor_in_bst_I
{
    public static class TreeNode
    {
        public final int      v;
        public final TreeNode left;
        public final TreeNode right;
        public final TreeNode parent;

        TreeNode(int _v, TreeNode _left, TreeNode _right, TreeNode _parent)
        {
            v = _v;
            left = _left;
            right = _right;
            parent = _parent;
        }
    }

    TreeNode next(TreeNode c)
    {
        if (c == null) {
            return null;
        }

        if (c.right != null) {
            TreeNode i = c.right;
            while (i.left != null) {
                i = i.left;
            }

            return i;
        }

        TreeNode i = c;
        while (i.parent != null && i == i.parent.right) {
            i = i.parent;
        }

        return i.parent;
    }
}