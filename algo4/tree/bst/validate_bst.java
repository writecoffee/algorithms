package bst;

import java.util.Stack;

public class validate_bst {
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

    public boolean isValidBST(TreeNode root) {
        return explore(root);
    }

    TreeNode pre = null;

    public boolean explore(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (!explore(root.left)) {
            return false;
        }

        if (pre != null && pre.val >= root.val) {
            return false;
        }

        pre = root;
        return explore(root.right);
    }

    boolean checkBSTWithMaxMinRange(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }

        if (root.val <= min || root.val > max) {
            return false;
        }

        return checkBSTWithMaxMinRange(root.left, min, root.val)
            && checkBSTWithMaxMinRange(root.right, root.val, max);
    }

    public boolean isValidBSTNonrecur(TreeNode root) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode next = root;
        TreeNode last = null;

        while (next != null || !s.isEmpty()) {
            if (next != null) {
                s.add(next);
                next = next.left;
            } else {
                TreeNode c = s.pop();

                if (last != null && last.val >= c.val) {
                    return false;
                }

                last = c;
                next = c.right;
            }
        }

        return true;
    }
}