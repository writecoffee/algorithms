/**
 * Given a binary tree, find the length of the longest consecutive sequence
 * path.
 *
 * The path refers to any sequence of nodes from some starting node to any node
 * in the tree along the parent-child connections. The longest consecutive path
 * need to be from parent to child (cannot be the reverse).
 *
 * For example,
 *
 *    1
 *     \
 *      3
 *     / \
 *    2   4
 *         \
 *          5
 *
 * Longest consecutive sequence path is 3-4-5, so return 3.
 *
 *    2
 *     \
 *      3
 *     /
 *    2
 *   /
 *  1
 *
 * Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
 *
 * [Source]     - {@linkplain https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/}
 * [Difficulty] - Medium
 *
 */
public class tr_longest_consecutive_sequence
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

    public int longestConsecutive(TreeNode root)
    {
        if (root == null) {
            return 0;
        }

        int[] gmax = new int[] { 0 };

        TreeNode psudo = new TreeNode(Integer.MAX_VALUE);
        psudo.right = root;
        search(psudo, root, gmax, 0);

        return gmax[0];
    }

    private void search(TreeNode parent, TreeNode current, int[] gmax, int preLength)
    {
        if (current == null) {
            return;
        }

        int curLength;
        if (parent.val == current.val - 1) {
            curLength = preLength + 1;
        } else {
            curLength = 1;
        }

        gmax[0] = Math.max(gmax[0], curLength);

        if (current.left != null) {
            search(current, current.left, gmax, curLength);
        }

        if (current.right != null) {
            search(current, current.right, gmax, curLength);
        }
    }
}
