package traversal;

import java.util.Stack;

public class turn_binary_tree_to_threaded_tree {
    public class TreeNode {
        public TreeNode left, right;
        public boolean isLeftThread, isRightThread;
    }

    public void convertToThreadedTree(TreeNode root) {
        explore(root, null, null);
    }

    void explore(TreeNode c, TreeNode pre, TreeNode post) {
        if (c == null) {
            return;
        }

        explore(c.left, pre, c);
        explore(c.right, c, post);

        if (c.left == null) {
            c.left = pre;
            c.isLeftThread = true;
        }

        if (c.right == null) {
            c.right = post;
            c.isRightThread = true;
        }
    }

    public void convertToThreadedTreeNonrecur(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode pre = null;
        TreeNode i = root;

        while (i != null || !s.isEmpty()) {
            if (i != null) {
                s.push(i);
                i = i.left;
            } else {
                TreeNode c = s.pop();

                if (c.left == null) {
                    c.left = pre;
                    c.isLeftThread = true;
                }

                pre = c;
                i = c.right;

                if (c.right == null) {
                    c.right = s.isEmpty() ? null : s.peek();
                    c.isRightThread = true;
                }
            }
        }
    }
}