package traversal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * Given a binary tree, return the vertical order traversal of its nodes' values.
 * (ie, from top to bottom, column by column).
 *
 * If two nodes are in the same row and column, the order should be from left to right.
 *
 * Examples:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * return its vertical order traversal as:
 *
 * [
 *   [9],
 *   [3,15],
 *   [20],
 *   [7]
 * ]
 *
 * Given binary tree [3,9,20,4,5,2,7],
 *
 *     _3_
 *    /   \
 *   9    20
 *  / \   / \
 * 4   5 2   7
 *
 * return its vertical order traversal as:
 *
 * [
 *   [4],
 *   [9],
 *   [3,5,2],
 *   [20],
 *   [7]
 * ]
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://leetcode.com/problems/binary-tree-vertical-order-traversal/}
 *
 */
public class tr_trav_vertical_order_traversal
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

    public List<List<Integer>> verticalOrder(TreeNode root)
    {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        Map<TreeNode, Integer> columns = new HashMap<>();
        columns.put(root, 0);
        Map<Integer, List<Integer>> verticals = new TreeMap<>();

        while (!q.isEmpty()) {
            Queue<TreeNode> p = new LinkedList<>(q);
            q.clear();

            while (!p.isEmpty()) {
                TreeNode c = p.poll();
                int col = columns.get(c);

                if (!verticals.containsKey(col)) {
                    verticals.put(col, new ArrayList<Integer>());
                }

                verticals.get(col).add(c.val);

                if (c.left != null) {
                    columns.put(c.left, col - 1);
                    q.add(c.left);
                }

                if (c.right != null) {
                    columns.put(c.right, col + 1);
                    q.add(c.right);
                }
            }
        }

        return new ArrayList<List<Integer>>(verticals.values());
    }
}
