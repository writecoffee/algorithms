package traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Given a non-empty binary search tree and a target value, find k values in the BST
 * that are closest to the target.
 *
 * Note:
 *
 * 1. Given target value is a floating point.
 *
 * 2. You may assume k is always valid, that is: k ≤ total nodes.
 *
 * 3. You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
 *
 * Follow up:
 *
 * Assume that the BST is balanced, could you solve it in less than O(n) runtime
 * (where n = total nodes)?
 *
 * Hint:
 *
 * 1. Consider implement these two helper functions:
 *      i.  getPredecessor(N), which returns the next smaller node to N.
 *      ii. getSuccessor(N), which returns the next larger node to N.
 *
 * 2. Try to assume that each node has a parent pointer, it makes the problem much easier.
 *
 * 3. Without parent pointer we just need to keep track of the path from the root to the current
 *    node using a stack.
 *
 * 4. You would need two stacks to track the path in finding predecessor and successor node
 *    separately.
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://leetcode.com/problems/closest-binary-search-tree-value-ii/}
 * [Tag]        - $stack$, $queue$
 *
 */
public class tr_trav_closest_binary_search_tree_value_II
{
    public class TreeNode
    {
        int      val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x)
        {
            val = x;
        }
    }

    public List<Integer> closestKValues(TreeNode root, double target, int k)
    {
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> left = new Stack<>();
        Queue<Integer> right = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        TreeNode c = root;
        while (c != null || !stack.isEmpty()) {
            if (c != null) {
                stack.push(c);
                c = c.left;
            } else {
                c = stack.pop();

                if (c.val < target) {
                    left.push(c.val);
                } else {
                    right.add(c.val);
                }

                c = c.right;
            }
        }

        for (int i = 0; i < k; i++) {
            if (left.isEmpty()) {
                result.add(right.poll());
            } else if (right.isEmpty()) {
                result.add(left.pop());
            } else if (Math.abs(left.peek() - target) < Math.abs(right.peek() - target)) {
                result.add(left.pop());
            } else {
                result.add(right.poll());
            }
        }

        return result;
    }
}
