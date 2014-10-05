package traversal;

public class tr_trav_postorder_successor_I
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

        if (c.parent == null) {
            return null;
        }

        if (c == c.parent.right || c.parent.right == null) {
            return c.parent;
        }

        TreeNode i = c.parent.right;
        while (i.left != null || i.right != null) {
            i = i.left != null ? i.left : i.right;
        }

        return i;
    }
}