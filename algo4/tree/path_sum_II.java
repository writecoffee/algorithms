import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * 
 * For example:
 * Given the below binary tree and sum = 22,
 * 
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 *         
 * return
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * http://oj.leetcode.com/problems/path-sum-ii/
 *
 */
public class path_sum_II {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if (root == null) {
            return result;
        }

        ArrayList<Integer> path = new ArrayList<Integer>();
        path.add(root.val);
        explore(root, sum - root.val, path, result);
        return result;
    }

    private void explore(TreeNode root, int sum, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> result) {
        if (root.left == null && root.right == null && sum == 0) {
            result.add(new ArrayList<Integer>(path));
            return;
        }

        if (root.left != null) {
            path.add(root.left.val);
            explore(root.left, sum - root.left.val, path, result);
            path.remove(path.size() - 1);
        }

        if (root.right != null) {
            path.add(root.right.val);
            explore(root.right, sum - root.right.val, path, result);
            path.remove(path.size() - 1);
        }
    }

    private class BtInfo {
        private final int cSum;
        private final TreeNode parent;

        private BtInfo(int _cSum, TreeNode _parent) {
            cSum = _cSum;
            parent = _parent;
        }
    }

    public ArrayList<ArrayList<Integer>> pathSumOptimized(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        IdentityHashMap<TreeNode, BtInfo> h = new IdentityHashMap<TreeNode, BtInfo>();
        q.add(root);
        h.put(root, new BtInfo(root.val, null));

        while (!q.isEmpty()) {
            Queue<TreeNode> p = new LinkedList<TreeNode>(q);
            q.clear();

            while (!p.isEmpty()) {
                TreeNode c = p.poll();
                TreeNode l = c.left;
                TreeNode r = c.right;
                int cSum = h.get(c).cSum;

                if (l == null && r == null && cSum == sum) {
                    result.add(backtrack(c, h));
                }

                if (l != null) {
                    q.add(l);
                    h.put(l, new BtInfo(cSum + l.val, c));
                }

                if (r != null) {
                    q.add(r);
                    h.put(r, new BtInfo(cSum + r.val, c));
                }
            }
        }

        return result;
    }

    private ArrayList<Integer> backtrack(TreeNode c, IdentityHashMap<TreeNode, BtInfo> h) {
        ArrayDeque<Integer> r = new ArrayDeque<Integer>();

        while (c != null) {
            r.addFirst(c.val);
            c = h.get(c).parent;
        }

        return new ArrayList<Integer>(r);
    }
}