public class maximum_path_sum {
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

    public static int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        result = Integer.MIN_VALUE;
        maxPathSumRecur(root);
        return result;
    }

    private int maxPathSumRecur(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int l = maxPathSumRecur(root.left);
        int r = maxPathSumRecur(root.right);
        int maxSumTillRoot = Math.max(root.val, Math.max(l, r) + root.val);
        result = Math.max(Math.max(result, maxSumTillRoot), l + r + root.val);

        return maxSumTillRoot;
    }

}