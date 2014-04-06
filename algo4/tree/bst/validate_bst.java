package bst;

import java.util.HashMap;
import java.util.Stack;

public class validate_bst {
    public static class TreeNode {
        public final int val;
        public final TreeNode left;
        public final TreeNode right;

        TreeNode(int _v, TreeNode _left, TreeNode _right) {
            val = _v;
            left = _left;
            right = _right;
        }
    }

    /**
     * Only work when the tree contains no duplicate values. 
     */
    public boolean isValidBST(TreeNode root) {
        return explore(root);
    }

    TreeNode pre = null;
    public boolean explore(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (!explore(root.left)) {
            return false;
        }

        if (pre != null && pre.val >= root.val) {
            return false;
        }

        pre = root;
        return explore(root.right);
    }

    /**
     * Work regardless of whether the tree has duplicate values or not. 
     */
    boolean checkBSTWithMaxMinRange(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }

        if (root.val <= min || root.val > max) {
            return false;
        }

        return checkBSTWithMaxMinRange(root.left, min, root.val)
            && checkBSTWithMaxMinRange(root.right, root.val, max);
    }

    /**
     * For any node T, T's value should be > any node in its left sub-tree
     * and < any node in its right sub-tree.
     */
    public boolean isValidBSTNonrecurNodup(TreeNode root) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode next = root;
        TreeNode last = null;

        while (next != null || !s.isEmpty()) {
            if (next != null) {
                s.add(next);
                next = next.left;
            } else {
                TreeNode c = s.pop();

                if (last != null && last.val >= c.val) {
                    return false;
                }

                last = c;
                next = c.right;
            }
        }

        return true;
    }

    class MaxMinPair {
        final int max;
        final int min;
        MaxMinPair(int _min, int _max) {
            min = _min;
            max = _max;
        }
    }

    /**
     * For any node T, T's value should be >= any node in its left sub-tree
     * and < any node in its right sub-tree.
     */
    public boolean isValidBSTNonrecur(TreeNode root) {
        if (root == null) {
            return true;
        }

        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        HashMap<TreeNode, MaxMinPair> h = new HashMap<TreeNode, MaxMinPair>();
        h.put(root, new MaxMinPair(Integer.MIN_VALUE, Integer.MAX_VALUE));

        while (!s.isEmpty()) {
            TreeNode c = s.pop();
            MaxMinPair info = h.get(c);

            if (info.min >= c.val || info.max < c.val) {
                return false;
            } else {
                h.remove(c);
            }

            if (c.right != null) {
                s.push(c.right);
                h.put(c.right, new MaxMinPair(c.val, info.max));
            }

            if (c.left != null) {
                s.push(c.left);
                h.put(c.left, new MaxMinPair(info.min, c.val));
            }
        }

        return true;
    }
}