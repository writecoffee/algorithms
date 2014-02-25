import java.util.ArrayDeque;
import java.util.Deque;

public class symmetric_tree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null || left.val != right.val) {
            return false;
        }

        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    public boolean isSymmetric(TreeNode root) {
        return (root == null) || isSymmetric(root.left, root.right);
    }

    public static boolean isSymmetricNonrecur(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            return true;
        } else if (root.left == null || root.right == null) {
            return false;
        }

        Deque<TreeNode> left = new ArrayDeque<TreeNode>();
        Deque<TreeNode> right = new ArrayDeque<TreeNode>();
        left.addLast(root.left);
        right.addLast(root.right);

        while (!left.isEmpty() && !right.isEmpty()) {
            TreeNode l = left.pollLast();
            TreeNode r = right.pollLast();

            if (l.val != r.val) {
                return false;
            }

            if (l.left != null && r.right != null && l.left.val == r.right.val) {
                left.addLast(l.left);
                right.addLast(r.right);
            } else if (!(l.left == null && r.right == null)) {
                return false;
            }

            if (l.right != null && r.left != null && l.right.val == r.left.val) {
                left.addLast(l.right);
                right.addLast(r.left);
            } else if (!(l.right == null && r.left == null)) {
                return false;
            }
        }

        return left.isEmpty() && right.isEmpty();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        isSymmetricNonrecur(root);
    }
}