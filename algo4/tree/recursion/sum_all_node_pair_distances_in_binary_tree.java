package recursion;

import java.util.HashMap;

/**
 * Given a binary tree, sum the distances between any pair of nodes
 * in the tree. The definition of the distance is the length of the
 * path from node a to node b.
 *
 * For example,
 *
 * Given a tree:
 *
 *          a
 *         /
 *        b
 *       /
 *      c
 *
 * The sum should be 4.
 *
 *          a
 *         /
 *        b
 *       / \
 *      c   f
 *     / \
 *    d   e
 *
 * The sum should be 19.
 * 
 * [Difficulty] - hard
 * [Source]     - facebook interview
 *
 */
public class sum_all_node_pair_distances_in_binary_tree {
    public static class TreeNode {
        public final char val;
        private TreeNode left, right;

        TreeNode(char _val) {
            val = _val;
        }
    }

    private static int gSum;

    public static int sumAllPair(TreeNode root) {
        if (root == null) {
            return 0;
        }

        gSum = 0;
        HashMap<TreeNode, Integer> h = new HashMap<TreeNode, Integer>();
        h.put(null, 0);
        getFlow(root, h);
        return gSum;
    }

    /**
     * Get how many number of flows that start off from node 'c'.
     * 
     * Flow(c) = Flow(c.left) * 2 + 
     *           Flow(c.right) * 2 +
     *           1 - Flow(c.left.left) - Flow(c.left.right)             (if c.left not null)   (1)
     *           1 - Flow(c.right.left) - Flow(c.right.right)           (if c.right not null)  (2)
     * 
     * In terms of (1) and (2), because those flows do not start from 'c', so we have to 
     * eliminate them from the result.
     *
     * For the sum of all flow lengths, we can simply accumulate all Flow(c_i), i in [0, n).
     * 
     */
    private static int getFlow(TreeNode c, HashMap<TreeNode, Integer> h) {
        int l = 0, r = 0, df = 0, neg = 0;

        if (c.left != null) {
            l = getFlow(c.left, h);
            df++;
            neg += h.get(c.left.left) + h.get(c.left.right);
        }

        if (c.right != null) {
            r = getFlow(c.right, h);
            df++;
            neg += h.get(c.right.left) + h.get(c.right.right);
        }

        int lSum = l * 2 + r * 2 + df - neg;
        gSum += lSum;
        h.put(c, lSum);
        return lSum;
    }

    public static void testCase1() {
        TreeNode n0 = new TreeNode('0');
        TreeNode na = new TreeNode('a');
        TreeNode nb = new TreeNode('b');
        TreeNode nc = new TreeNode('c');
        TreeNode nd = new TreeNode('d');
        TreeNode ne = new TreeNode('e');
        n0.left = na;
        na.left = nb;
        nb.left = nc;
        nc.left = nd;
        nc.right = ne;
        assert sumAllPair(n0) == 30;
    }

    public static void testCase2() {
        TreeNode na = new TreeNode('a');
        TreeNode nb = new TreeNode('b');
        TreeNode nc = new TreeNode('c');
        na.left = nb;
        nb.left = nc;
        assert sumAllPair(na) == 4;
    }

    public static void testCase3() {
        TreeNode na = new TreeNode('a');
        TreeNode nb = new TreeNode('b');
        TreeNode nc = new TreeNode('c');
        TreeNode nd = new TreeNode('d');
        TreeNode ne = new TreeNode('e');
        TreeNode nf = new TreeNode('f');
        na.left = nb;
        nb.left = nc;
        nb.right = nf;
        nc.left = nd;
        nc.right = ne;
        assert sumAllPair(na) == 19;
    }

    public static void main(String[] args) {
        testCase1();
        testCase2();
        testCase3();
    }
}