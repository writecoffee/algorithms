package traversal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class binary_tree_postorder_traversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }

        if (root.left != null) {
            result.addAll(postorderTraversal(root.left));
        }

        if (root.right != null) {
            result.addAll(postorderTraversal(root.right));
        }

        result.add(root.val);
        return result;
    }

    public ArrayList<Integer> postorderTraversalNonrecur(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }

        Set<TreeNode> visited = new HashSet<TreeNode>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);

        while (!s.isEmpty()) {
            TreeNode c = s.peek();

            if (visited.contains(c)) {
                result.add(s.pop().val);
                continue;
            }

            if (c.right != null) {
                s.push(c.right);
            }

            if (c.left != null) {
                s.push(c.left);
            }

            visited.add(c);
        }

        return result;
    }
}