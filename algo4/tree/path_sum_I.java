import java.util.IdentityHashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * 
 * For example:
 * Given the below binary tree and sum = 22,
 * 
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 *         
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * 
 * http://oj.leetcode.com/problems/path-sum/
 * 
 */
public class path_sum_I {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return sum == root.val;
        }

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public boolean hasPathSumOptimized(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        IdentityHashMap<TreeNode, Integer> h = new IdentityHashMap<TreeNode, Integer>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        h.put(root, root.val);

        while (!q.isEmpty()) {
            Queue<TreeNode> p = new LinkedList<TreeNode>(q);
            q.clear();

            while (!p.isEmpty()) {
                TreeNode c = p.poll();
                TreeNode l = c.left;
                TreeNode r = c.right;
                int cSum = h.get(c);

                if (l == null && r == null && cSum == sum) {
                    return true;
                }

                if (l != null) {
                    q.add(l);
                    h.put(l, l.val + cSum);
                }

                if (r != null) {
                    q.add(r);
                    h.put(r, r.val + cSum);
                }
            }
        }

        return false;
    }
}