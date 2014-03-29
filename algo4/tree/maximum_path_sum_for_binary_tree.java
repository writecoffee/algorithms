public class maximum_path_sum_for_binary_tree {
    public static class TreeNode {
        public final int val;
        public final TreeNode left;
        public final TreeNode right;

        TreeNode(int _v, TreeNode _left, TreeNode _right) {
            val = _v;
            left = _left;
            right = _right;
        }
    }

    public static int gMax;

    public int maxPathSum(TreeNode root) {
        gMax = Integer.MIN_VALUE;
        maxPathSumRecur(root);
        return gMax;
    }

    private int maxPathSumRecur(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int l = maxPathSumRecur(root.left);
        int r = maxPathSumRecur(root.right);

        int lMax;
        if (l < 0 && r < 0) {
            lMax = root.val;
        } else {
            lMax = Math.max(l, r) + root.val;
        }

        gMax = Math.max(Math.max(gMax, lMax), l + r + root.val);
        return lMax;
    }
}