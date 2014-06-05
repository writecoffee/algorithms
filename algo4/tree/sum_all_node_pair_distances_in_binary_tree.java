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
 *       /
 *      c
 *     / \
 *    d   e
 *
 * The sum should be 16.
 *
 */
public class sum_all_node_pair_distances_in_binary_tree {
    private class TreeNode {
        private final char val;
        private TreeNode left, right;

        TreeNode(char _val) {
            val = _val;
        }
    }

    private int gSum;

    public int sumAllPair(TreeNode root) {
        if (root == null) {
            return 0;
        }

        gSum = 0;

        if (root.left != null) {
            explore(root.left);
        }

        if (root.right != null) {
            explore(root.right);
        }

        return gSum;
    }

    private int explore(TreeNode c) {
        int l = 0, r = 0;

        if (c.left != null) {
            l = explore(c.left) + 1;
        }

        if (c.right != null) {
            gSum -= l - 1;
            r = explore(c.right) + 1;
            gSum += l - 1;
        }

        gSum += l + 1 + r;
        return gSum;
    }
}
