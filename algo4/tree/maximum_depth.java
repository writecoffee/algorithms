import java.util.HashMap;
import java.util.Stack;

public class maximum_depth {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        if (root.left == null) {
            return maxDepth(root.right) + 1;
        } else if (root.right == null) {
            return maxDepth(root.left) + 1;
        } else {
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }

    public int maxDepthNonrecur(TreeNode root) {
        if (root == null) {
            return 0;
        }

        HashMap<TreeNode, Integer> h = new HashMap<TreeNode, Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        h.put(root, 1);
        int result = 0;

        while (!s.isEmpty()) {
            TreeNode c = s.pop();

            if (c.left == null && c.right == null) {
                result = Math.max(result, h.get(c));
                continue;
            }

            if (c.right != null) {
                s.push(c.right);
                h.put(c.right, h.get(c) + 1);
            }

            if (c.left != null) {
                s.push(c.left);
                h.put(c.left, h.get(c) + 1);
            }
        }

        return result;
    }
}