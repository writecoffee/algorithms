import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

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

        Deque<TreeNode> intermediate = new ArrayDeque<TreeNode>();
        Set<TreeNode> isVisited = new HashSet<TreeNode>();
        intermediate.addLast(root);
        while (!intermediate.isEmpty()) {
            TreeNode current = intermediate.pollLast();

            if (current.left != null && isVisited.contains(current.left)) {
                isVisited.add(current);
                result.add(current.val);
                continue;
            }

            if (current.left == null) {
                isVisited.add(current);
                result.add(current.val);

                if (current.right != null && !isVisited.contains(current.right)) {
                    intermediate.addLast(current.right);
                }
            } else {
                if (current.right != null && !isVisited.contains(current.right)) {
                    intermediate.addLast(current.right);
                }

                intermediate.addLast(current);
                intermediate.addLast(current.left);
            }
        }

        return result;
    }
}