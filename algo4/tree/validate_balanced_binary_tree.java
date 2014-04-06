import java.util.HashMap;
import java.util.Stack;

public class validate_balanced_binary_tree {
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

    public boolean isBalancedNonrecur(TreeNode root) {
        if (root == null) {
            return true;
        }

        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        HashMap<TreeNode, Integer> h = new HashMap<TreeNode, Integer>();
        while (!s.isEmpty()) {
            TreeNode c = s.peek();

            if (h.containsKey(c)) {
                int l = c.left == null ? 0 : h.get(c.left);
                int r = c.right == null ? 0 : h.get(c.right);

                if (Math.abs(l - r) > 1) {
                    return false;
                }

                s.pop();
                h.put(c, Math.max(l, r) + 1);
                continue;
            }

            if (c.right != null) {
                s.push(c.right);
            }

            if (c.left != null) {
                s.push(c.left);
            }

            h.put(c, -1);
        }

        return true;
    }
}