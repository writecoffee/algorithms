package traversal;

import java.util.ArrayList;
import java.util.Stack;

class binary_tree_inorder_traversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        if (root == null) {
            return result;
        }

        if (root.left != null) {
            result.addAll(inorderTraversal(root.left));
        }

        result.add(root.val);

        if (root.right != null) {
            result.addAll(inorderTraversal(root.right));
        }

        return result;
    }

    public static ArrayList<Integer> inorderTraversalIterative(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode c = root;

        while (c != null || !s.isEmpty()) {
            if (c != null) {
                s.push(c);
                c = c.left;
            } else if (!s.isEmpty()) {
                TreeNode next = s.pop();
                result.add(next.val);
                c = next.right;
            }
        }

        return result;
    }
}