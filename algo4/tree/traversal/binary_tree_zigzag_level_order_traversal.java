package traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class binary_tree_zigzag_level_order_traversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        boolean flipped = false;

        while (!q.isEmpty()) {
            Queue<TreeNode> p = new LinkedList<TreeNode>(q);
            q.clear();
            ArrayList<Integer> t = new ArrayList<Integer>();

            while (!p.isEmpty()) {
                TreeNode c = p.poll();
                t.add(c.val);

                if (c.left != null) {
                    q.add(c.left);
                }

                if (c.right != null) {
                    q.add(c.right);
                }
            }

            if (flipped) {
                Collections.reverse(t);
            }

            result.add(t);
            flipped = !flipped;
        }

        return result;
    }

    public ArrayList<ArrayList<Integer>> zigzagLevelOrderUsingOneVector(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return result;
        }

        Deque<TreeNode> q = new ArrayDeque<TreeNode>();
        q.add(root);
        boolean flipped = false;

        while (!q.isEmpty()) {
            Deque<TreeNode> p = new ArrayDeque<TreeNode>(q);
            q.clear();
            ArrayList<Integer> t = new ArrayList<Integer>();

            while (!p.isEmpty()) {
                TreeNode c = flipped ? p.pollLast() : p.pollFirst();
                t.add(c.val);

                if (flipped) {
                    if (c.right != null) {
                        q.addFirst(c.right);
                    }
                    if (c.left != null) {
                        q.addFirst(c.left);
                    }
                } else {
                    if (c.left != null) {
                        q.addLast(c.left);
                    }
                    if (c.right != null) {
                        q.addLast(c.right);
                    }
                }
            }

            result.add(t);
            flipped = !flipped;
        }

        return result;
    }
}