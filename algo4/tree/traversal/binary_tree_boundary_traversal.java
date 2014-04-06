package traversal;

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

    private static void printLeaves(TreeNode c, ArrayList<Integer> result) {
        if (c == null) {
            return;
        }

        if (c.left == null && c.right == null) {
            result.add(c.val);
            return;
        }

        printLeaves(c.left, result);
        printLeaves(c.right, result);
    }

    private static void printLeftBoundary(TreeNode c, ArrayList<Integer> result) {
        if (c == null) {
            return;
        }

        if (c.left != null) {
            result.add(c.val);
            printLeftBoundary(c.left, result);
        } else if (c.right != null) {
            result.add(c.val);
            printLeftBoundary(c.right, result);
        }
    }

    private static void printRightBoundary(TreeNode c, ArrayList<Integer> result) {
        if (c == null) {
            return;
        }

        if (c.right != null) {
            printRightBoundary(c.right, result);
            result.add(c.val);
        } else if (c.left != null) {
            printRightBoundary(c.left, result);
            result.add(c.val);
        }
    }

    /**               
     *                20
     *              /    \                
     *             /      \ 
     *            8        22
     *           / \       / \
     *          4   12   21   25
     *           \   \        / 
     *            7   14    24
     * 
     */
    public static void main(String[] args) {
        TreeNode n20 = new TreeNode(20);
        TreeNode n8 = new TreeNode(8);
        TreeNode n4 = new TreeNode(4);
        TreeNode n7 = new TreeNode(7);
        TreeNode n12 = new TreeNode(12);
        TreeNode n14 = new TreeNode(14);
        TreeNode n21 = new TreeNode(21);
        TreeNode n22 = new TreeNode(22);
        TreeNode n25 = new TreeNode(25);
        TreeNode n24 = new TreeNode(24);
        n20.left = n8;
        n20.right = n22;
        n8.left = n4;
        n8.right = n12;
        n4.right = n7;
        n12.right = n14;
        n22.left = n21;
        n22.right = n25;
        n25.left = n24;

        for (Integer i : printBoundary(n20)) {
            System.out.println(i);
        }
    }
}