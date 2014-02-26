public class balanced_binary_tree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return treeHeight(root) >= 0;
    }

    int treeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lDepth = treeHeight(root.left);
        int rDepth = treeHeight(root.right);
        if (lDepth < 0 || rDepth < 0 || Math.abs(lDepth - rDepth) > 1) {
            return -1;
        } else {
            return Math.max(lDepth, rDepth) + 1;
        }
    }
}