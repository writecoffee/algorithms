import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class binary_tree_level_order_traversal_II {
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

        Queue<TreeNode> levelTraversal = new LinkedList<TreeNode>();
        levelTraversal.add(root);

        while (!levelTraversal.isEmpty()) {
            ArrayList<Integer> valuesPrintout = new ArrayList<Integer>();
            levelTraversal.add(null);

            while (levelTraversal.peek() != null) {
                TreeNode current = levelTraversal.poll();

                if (current.left != null) {
                    levelTraversal.add(current.left);
                }

                if (current.right != null) {
                    levelTraversal.add(current.right);
                }

                valuesPrintout.add(current.val);
            }
            levelTraversal.poll();

            result.addFirst(valuesPrintout);
        }

        return new ArrayList<ArrayList<Integer>>(result);
    }
}