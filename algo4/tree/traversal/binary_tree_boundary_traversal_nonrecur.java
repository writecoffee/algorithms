package traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

public class binary_tree_boundary_traversal_nonrecur {
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

        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode c = s.pop();

            if (c.left == null && c.right == null) {
                result.add(c.val);
                continue;
            }

            if (c.right != null) {
                s.push(c.right);
            }

            if (c.left != null) {
                s.push(c.left);
            }
        }
    }

    private static void printLeftBoundary(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }

        TreeNode c = root;
        while (true) {
            if (c.left != null) {
                result.add(c.val);
                c = c.left;
            } else if (c.right != null) {
                result.add(c.val);
                c = c.right;
            } else {
                break;
            }
        }
    }

    private static void printRightBoundary(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }

        Deque<Integer> t = new ArrayDeque<Integer>();
        TreeNode c = root;
        while (true) {
            if (c.right != null) {
                t.addFirst(c.val);
                c = c.right;
            } else if (c.left != null) {
                t.addFirst(c.val);
                c = c.left;
            } else {
                break;
            }
        }

        result.addAll(t);
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