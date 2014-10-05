package recursion;

/**
 * Given a binary tree, count the number of uni-value subtrees.
 *
 * A Uni-value subtree means all nodes of the subtree have the same value.
 *
 * For example:
 *
 * Given binary tree,
 *              5
 *             / \
 *            1   5
 *           / \   \
 *          5   5   5
 *
 * return 4.
 *
 * [Source]     - {@linkplain https://leetcode.com/problems/count-univalue-subtrees/}
 * [Difficulty] - Medium
 *
 */
public class tr_recur_count_univalue_subtrees
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

    /**
     * Define recursion:
     *
     * R(node): true only if { (1) node != null
     *                          && R(node.left)
     *                          && R(node.right)
     *                          && node.val == Parent(node).val
     *
     *                         (2) node == null }
     *
     * C(node): contribute 1 only if R(node.left) && R(node.right).
     *
     */
    public int countUnivalSubtrees(TreeNode root)
    {
        if (root == null) {
            return 0;
        }

        int[] counter = new int[1];
        count(root, counter, root.val);

        return counter[0];
    }

    private boolean count(TreeNode root, int[] counter, int val)
    {
        if (root == null) {
            return true;
        }

        boolean l = count(root.left, counter, root.val);
        boolean r = count(root.right, counter, root.val);

        if (l && r) {
            counter[0]++;
        }

        return l && r && root.val == val;
    }
}
