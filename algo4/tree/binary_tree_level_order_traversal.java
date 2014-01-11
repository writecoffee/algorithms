import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

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

        Deque<TreeNode> intermediate = new ArrayDeque<TreeNode>();
        Deque<TreeNode> outerIntermediate = new ArrayDeque<TreeNode>();
        outerIntermediate.addLast(root);

        while (!outerIntermediate.isEmpty()) {
            Deque<TreeNode> tempForSwap = outerIntermediate;
            outerIntermediate = intermediate;
            intermediate = tempForSwap;

            ArrayList<Integer> intermediateResult = new ArrayList<Integer>();
            while (!intermediate.isEmpty()) {
                TreeNode currNode = intermediate.pollFirst();
                if (currNode.left != null) {
                    outerIntermediate.add(currNode.left);
                }

                if (currNode.right != null) {
                    outerIntermediate.add(currNode.right);
                }

                intermediateResult.add(currNode.val);
            }
            result.add(intermediateResult);
        }

        return result;
    }

    public static void main(String[] args) {
        levelOrder(new TreeNode(3));
    }
}