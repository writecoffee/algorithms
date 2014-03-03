public class determine_binary_tree {
    public static class TreeNode {
        public final int v;
        public final TreeNode left;
        public final TreeNode right;

        TreeNode(int _v, TreeNode _left, TreeNode _right) {
            v = _v;
            left = _left;
            right = _right;
        }
    }

    boolean checkBSTStitchingLastValue(TreeNode root, Integer lastValue) {
        if (root == null) {
            return true;
        }

        if (!checkBSTStitchingLastValue(root.left, lastValue)) {
            return false;
        }

        if (lastValue > root.v) {
            return false;
        }

        lastValue = root.v;
        return checkBSTStitchingLastValue(root.right, lastValue);
    }

    boolean checkBSTWithMaxMinRange(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        
        if (root.v <= min || root.v > max) {
            return false;
        }

        return checkBSTWithMaxMinRange(root.left, min, root.v)
            && checkBSTWithMaxMinRange(root.right, root.v, max);
    }
}