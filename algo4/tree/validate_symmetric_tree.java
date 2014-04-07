import java.util.Stack;

public class validate_symmetric_tree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        return (root == null) || isSymmetric(root.left, root.right);
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

    public static boolean isSymmetricNonrecur(TreeNode root) {
        if (root == null) {
            return true;
        }

        Stack<TreeNode> ls = new Stack<TreeNode>();
        Stack<TreeNode> rs = new Stack<TreeNode>();

        if (root.left != null && root.right != null) {
            ls.push(root.left);
            rs.push(root.right);
        } else if (!(root.left == null && root.right == null)) {
            return false;
        }

        while (!ls.isEmpty() && !rs.isEmpty()) {
            TreeNode lc = ls.pop();
            TreeNode rc = rs.pop();

            if (lc.val != rc.val) {
                return false;
            }

            if (lc.left != null && rc.right != null) {
                ls.push(lc.left);
                rs.push(rc.right);
            } else if (!(lc.left == null && rc.right == null)) {
                return false;
            }

            if (lc.right != null && rc.left != null) {
                ls.push(lc.right);
                rs.push(rc.left);
            } else if (!(lc.right == null && rc.left == null)) {
                return false;
            }
        }

        return ls.isEmpty() && rs.isEmpty();
    }
}