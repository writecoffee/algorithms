import java.util.ArrayDeque;
import java.util.Deque;

public class flatten_binary_tree_to_linked_list {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    void flatten(TreeNode root) {
        flattenHelper(root);
    }

    TreeNode flattenHelper(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode rightTree = root.right;
        TreeNode last = root;

        if (root.left != null) {
            last = flattenHelper(root.left);
            root.right = root.left;
            root.left = null;
        }

        if (rightTree != null) {
            last.right = rightTree;
            last = flattenHelper(root.right);
        }

        return last;
    }

    static void flattenNonrecur(TreeNode root) {
        TreeNode last = root;
        Deque<TreeNode> rightTrees = new ArrayDeque<TreeNode>();

        while (last != null) {
            while (last.left != null) {
                if (last.right != null) {
                    rightTrees.addLast(last.right);
                }

                last.right = last.left;
                last.left = null;
                last = last.right;
            }

            if (last.right == null && !rightTrees.isEmpty()) {
                last.right = rightTrees.pollLast();
            }

            last = last.right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(4);
        TreeNode rightLeft = new TreeNode(3);
        root.left = left;
        root.right = right;
        right.left = rightLeft;
        flattenNonrecur(root);
    }
}