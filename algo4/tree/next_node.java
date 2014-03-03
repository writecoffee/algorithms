public class next_node {
    public static class TreeNode {
        public final int v;
        public final TreeNode left;
        public final TreeNode right;
        public final TreeNode parent;

        TreeNode(int _v, TreeNode _left, TreeNode _right, TreeNode _parent) {
            v = _v;
            left = _left;
            right = _right;
            parent = _parent;
        }
    }

    TreeNode next(TreeNode n, TreeNode node) {
        if (n == null) {
            return null;
        }

        if (n.right != null) {
            TreeNode current = n.right;
            while (current.left != null) {
                current = current.left;
            }

            return current;
        }

        TreeNode current = n;
        while (current.parent != null && current == current.parent.right) {
            current = current.parent;
        }

        return current.parent;
    }
}