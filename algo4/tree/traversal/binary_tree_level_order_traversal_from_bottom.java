package traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class binary_tree_level_order_traversal_from_bottom {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        Deque<ArrayList<Integer>> result = new ArrayDeque<ArrayList<Integer>>();
        if (root == null) {
            return new ArrayList<ArrayList<Integer>>(result);
        }

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);

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

            result.addFirst(t);
        }

        return new ArrayList<ArrayList<Integer>>(result);
    }
}