package traversal;

import java.util.ArrayList;
import java.util.Stack;

public class binary_tree_preorder_traversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        if (root == null) {
            return result;
        }

        result.add(root.val);

        if (root.left != null) {
            result.addAll(preorderTraversal(root.left));
        }

        if (root.right != null) {
            result.addAll(preorderTraversal(root.right));
        }

        return result;
    }

    public ArrayList<Integer> preorderTraversalNonrecur(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);

        while (!s.isEmpty()) {
            TreeNode c = s.pop();
            result.add(c.val);

            if (c.right != null) {
                s.push(c.right);
            }

            if (c.left != null) {
                s.push(c.left);
            }
        }

        return result;
    }
}