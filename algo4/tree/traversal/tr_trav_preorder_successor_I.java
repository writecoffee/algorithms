package traversal;

public class tr_trav_preorder_successor_I
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

        if (c.left != null) {
            return c.left;
        } else if (c.right != null) {
            return c.right;
        }

        TreeNode i = c;
        while (i.parent != null && ((i.parent.left == i && i.parent.right == null) || i.parent.right == i)) {
            i = i.parent;
        }

        return i.parent == null ? null : i.parent.right;
    }
}
