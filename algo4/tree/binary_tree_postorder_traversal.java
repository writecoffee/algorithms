import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

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

        Set<TreeNode> isVisited = new HashSet<TreeNode>();
        Deque<TreeNode> intermediate = new ArrayDeque<TreeNode>();
        intermediate.addLast(root);

        while (!intermediate.isEmpty()) {
            TreeNode currNode = intermediate.peekLast();

            if (isVisited.contains(currNode) || (currNode.left == null && currNode.right == null)) {
                result.add(intermediate.pollLast().val);
                continue;
            }

            if (currNode.right != null) {
                intermediate.addLast(currNode.right);
            }

            if (currNode.left != null) {
                intermediate.addLast(currNode.left);
            }

            isVisited.add(currNode);
        }

        isVisited.clear();
        return result;
    }

    public static void main(String[] args) {

    }
}