package recursion;

import java.util.HashMap;

/**
 * Given a binary tree, sum the distances between any pair of nodes in the tree. The definition of the
 * distance is the length of the path from node a to node b.
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
public class tr_recur_sum_all_node_pair_distances_in_binary_tree {
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
     * Get the sum of length of flows which can start from node 'c'.
     * 
     * F_SUM(c) = NUM_FLOW(c.left) * 2 + 
     *            NUM_FLOW(c.right) * 2 +
     *            1 - NUM_FLOW(c.left.left) - NUM_FLOW(c.left.right)       (if c.left not null, 0 otherwise)
     *            1 - NUM_FLOW(c.right.left) - NUM_FLOW(c.right.right)     (if c.right not null, 0 otherwise)  (a)
     * 
     * Also, the key theorem here is that F_SUM means not only the sum of length of flows which
     * start from 'c', but also means the number of flows within sub-tree 'c'.
     * 
     * Now we'll prove the theorem above: F_SUM(c) = NUM_FLOW(c)
     * 
     * (1) Base Case
     * 
     *     When the tree has only three levels, it's straightforward that in level 1 and level 2,
     *     F_SUM = NUM_FLOW. So for the root, we can compute F_SUM(root) by 
     * 
     *     NUM_FLOW(level-1 node) * 2 + NUMBER_OF_CHILDREN
     * 
     *     Because for level-1 nodes, doubling the number of flows is equivalent to getting the
     *     lengths of paths that start from the root and end at the leaf. So for base case, the
     *     formula holds.
     * 
     * (2) Inductive Hypothesis
     * 
     *     For tree with k - 1 levels (where k > 4), we assume F_SUM(root_{k - 1}) = NUM_FLOW(root_{k - 1}).
     * 
     *     For level k, firstly, F_SUM(root_k) can be computed by the formula (a) as listed above.
     *     As all flows in its left and right sub-trees got doubled, that can also be regarded as the
     *     length of all flows plus one. But some flows that are 2 levels away from rook_k can not be
     *     linked by root_k. These can be simply eliminated by the third and fourth line in formula (a).
     * 
     *     For NUM_FLOW(root_k), formula (a) can also be illustrated in another way: from left and right
     *     sub-tree of root_k, after multiplying by 2, we get the new flows that start from root_k, also
     *     together with some redundant flows which cannot linked by root_k but just got taken into
     *     account for the sum redundantly. After we eliminate these flows, we can get the exact result.
     * 
     *     So, for level k, we can also get the same result F_SUM(root_k) = NUM_FLOW(root_k).
     * 
     * Finally, we need to get the sum of all flow lengths, we can just simply accumulate all F_SUM(c_i)
     * results, where i lies within [0, n), n is the number of nodes in the tree.
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