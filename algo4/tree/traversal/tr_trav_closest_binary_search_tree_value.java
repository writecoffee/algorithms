package traversal;

/**
 * Given a non-empty binary search tree and a target value, find the value in
 * the BST that is closest to the target.
 *
 * Note:
 *
 * Given target value is a floating point.
 *
 * You are guaranteed to have only one unique value in the BST that is closest
 * to the target.
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://leetcode.com/problems/closest-binary-search-tree-value/}
 *
 */
public class tr_trav_closest_binary_search_tree_value
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

    public int closestValue(TreeNode root, double target)
    {
        int a = root.val;
        TreeNode kid = target < a ? root.left : root.right;

        if (kid == null) {
            return a;
        }

        int b = closestValue(kid, target);
        return Math.abs(a - target) < Math.abs(b - target) ? a : b;
    }

    public int closestValueIterative(TreeNode root, double target)
    {
        TreeNode c = root;
        int result = c.val;

        while (c != null) {
            result = Math.abs(c.val - target) < Math.abs(result - target) ? c.val : result;

            if (c.val > target) {
                c = c.left;
            } else {
                c = c.right;
            }
        }

        return result;
    }
}
