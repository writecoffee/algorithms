import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;

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

        Deque<TreeNode> intermediate = new ArrayDeque<TreeNode>();
        Deque<TreeNode> innerIntermediate = new ArrayDeque<TreeNode>();
        intermediate.addLast(root);
        int level = 0;

        while (!intermediate.isEmpty()) {
            Deque<TreeNode> temp = innerIntermediate;
            innerIntermediate = intermediate;
            intermediate = temp;
            ArrayList<Integer> intermediateResult = new ArrayList<Integer>();

            while (!innerIntermediate.isEmpty()) {
                TreeNode current = innerIntermediate.pollFirst();
                intermediateResult.add(current.val);

                if (current.left != null) {
                    intermediate.addLast(current.left);
                }

                if (current.right != null) {
                    intermediate.addLast(current.right);
                }
            }

            if (level % 2 == 0) {
                result.add(intermediateResult);
            } else {
                Collections.reverse(intermediateResult);
                result.add(intermediateResult);
            }

            level++;
        }

        return result;
    }

}