package bst;

import java.util.Stack;

public class recover_bst {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void recoverTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }

        TreeNode[] t = new TreeNode[2];
        explore(root, t, null);
        swap(t[0], t[1]);
    }

    private TreeNode explore(TreeNode root, TreeNode[] t, TreeNode pre) {
        if (root == null) {
            return pre;
        }

        TreeNode last = explore(root.left, t, pre);
        if (last != null && last.val > root.val) {
            t[1] = root;
            t[0] = t[0] == null ? last : t[0];
        }

        return explore(root.right, t, root);
    }

    private void swap(TreeNode l, TreeNode r) {
        int temp = l.val;
        l.val = r.val;
        r.val = temp;
    }

    public void recoverTreeNonrecur(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }

        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode[] t = new TreeNode[2];
        TreeNode last = null;
        TreeNode next = root;

        while (next != null || !s.isEmpty()) {
            if (next != null) {
                s.push(next);
                next = next.left;
            } else {
                TreeNode c = s.pop();
                if (last != null && last.val > c.val) {
                    t[1] = c;
                    t[0] = t[0] == null ? last : t[0];
                }

                last = c;
                next = c.right;
            }
        }

        swap(t[0], t[1]);
    }
}
