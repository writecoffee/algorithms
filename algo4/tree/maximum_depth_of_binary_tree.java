import java.util.ArrayDeque;
import java.util.Deque;

public class maximum_depth_of_binary_tree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        Deque<TreeNode> outer = new ArrayDeque<TreeNode>();
        if (root == null) {
            return 0;
        }

        outer.addLast(root);
        int level = 0;
        while (!outer.isEmpty()) {
            Deque<TreeNode> inner = new ArrayDeque<TreeNode>(outer);
            outer.clear();

            while (!inner.isEmpty()) {
                TreeNode current = inner.pollFirst();

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