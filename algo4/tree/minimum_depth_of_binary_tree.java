import java.util.ArrayDeque;
import java.util.Deque;

public class minimum_depth_of_binary_tree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        if (root.left == null) {
            return minDepth(root.right) + 1;
        } else if (root.right == null) {
            return minDepth(root.left) + 1;
        } else {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }

    public int minDepthNonrecur(TreeNode root) {
        Deque<TreeNode> outer = new ArrayDeque<TreeNode>();

        if (root == null) {
            return 0;
        }

        int level = 1;
        outer.addLast(root);
        while (!outer.isEmpty()) {
            Deque<TreeNode> inner = new ArrayDeque<TreeNode>(outer);
            outer.clear();

            while (!inner.isEmpty()) {
                TreeNode current = inner.pollLast();

                if (current.left == null && current.right == null) {
                    return level;
                }

                if (current.left != null) {
                    outer.addLast(current.left);
                }

                if (current.right != null) {
                    outer.addLast(current.right);
                }
            }

            level++;
        }

        return level;
    }
}