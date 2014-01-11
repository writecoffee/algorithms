import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

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

        Deque<TreeNode> intermediate = new ArrayDeque<TreeNode>();
        intermediate.addLast(root);
        while (!intermediate.isEmpty()) {
            TreeNode curr = intermediate.pollLast();
            result.add(curr.val);
            if (curr.right != null) {
                intermediate.addLast(curr.right);
            }
            if (curr.left != null) {
                intermediate.addLast(curr.left);
            }
        }

        return result;
    }

    public static void main(String[] args) {

    }

}