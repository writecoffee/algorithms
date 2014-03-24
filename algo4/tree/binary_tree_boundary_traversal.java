import java.util.ArrayList;

public class binary_tree_boundary_traversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static ArrayList<Integer> printBoundary(TreeNode root) {
        assert root != null;
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(root.val);

        printLeftBoundary(root.left, result);
        printLeaves(root.left, result);
        printLeaves(root.right, result);
        printRightBoundary(root.right, result);

        return result;
    }

    private static void printLeaves(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            result.add(root.val);
            return;
        }

        printLeaves(root.left, result);
        printLeaves(root.right, result);
    }

    private static void printLeftBoundary(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            result.add(root.val);
            printLeftBoundary(root.left, result);
        } else if (root.right != null) {
            result.add(root.val);
            printLeftBoundary(root.right, result);
        }
    }

    private static void printRightBoundary(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }

        if (root.right != null) {
            result.add(root.val);
            printRightBoundary(root.right, result);
        } else if (root.left != null) {
            result.add(root.val);
            printRightBoundary(root.left, result);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);
        root.right = new TreeNode(22);
        root.right.right = new TreeNode(25);

        for (Integer i : printBoundary(root)) {
            System.out.println(i);
        }
    }
}