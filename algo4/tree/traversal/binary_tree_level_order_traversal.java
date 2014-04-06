package traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class binary_tree_level_order_traversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return result;
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

            result.add(t);
        }

        return result;
    }

    public static void main(String[] args) {
        levelOrder(new TreeNode(3));
    }
}