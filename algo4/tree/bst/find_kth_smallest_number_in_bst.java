package bst;

import java.util.Stack;

public class find_kth_smallest_number_in_bst {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int findKthNumber(TreeNode node, int k) {
        if (node == null) {
            return -1;
        }

        int i = 0;
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode nxt = node;

        while (nxt != null || !s.isEmpty()) {
            if (nxt != null) {
                s.push(nxt);
                nxt = nxt.left;
            } else {
                TreeNode c = s.pop();

                if (i == k - 1) {
                    return c.val;
                } else {
                    i++;
                }

                if (c.right != null) {
                    nxt = c.right;
                }
            }
        }

        return -1;
    }
}