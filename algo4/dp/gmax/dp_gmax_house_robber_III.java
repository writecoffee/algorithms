package gmax;

/**
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area,
 * called the "root." Besides the root, each house has one and only one parent house. After a tour,
 * the smart thief realized that "all houses in this place forms a binary tree".
 *
 * It will automatically contact the police if two directly-linked houses were broken into on the same
 * night.
 *
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 *
 * Example 1:
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 *
 * Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 *
 * Example 2:
 *      3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 *
 * Maximum amount of money the thief can rob = 4 + 5 = 9.
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://leetcode.com/problems/house-robber-iii/}
 *
 */
public class dp_gmax_house_robber_III
{
    public class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int rob(TreeNode root)
    {
        int[] result = explore(root);
        return Math.max(result[0], result[1]);
    }

    private int[] explore(TreeNode c)
    {
        if (c == null) {
            return new int[] { 0, 0 };
        }

        int[] left = explore(c.left);
        int[] right = explore(c.right);

        int selected = left[1] + right[1] + c.val;
        int nonselected = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[] { selected, nonselected };
    }
}
