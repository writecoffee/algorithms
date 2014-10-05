package uniqueways;

/**
 * There is a fence with n posts, each post can be painted with one of the k
 * colors.
 *
 * You have to paint all the posts such that no more than two adjacent fence
 * posts have the same color.
 *
 * Return the total number of ways you can paint the fence.
 *
 * Note:
 *
 * n and k are non-negative integers.
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://leetcode.com/problems/paint-fence/}
 *
 */
public class dp_unique_paint_fences
{
    /**
     * s means same and stands for the last element of your dp1; d means
     * different, d1 and d2 stands for the last two elements of your dp2.
     *
     * In each loop, dp1[i] = dp2[i - 1] turns into s = d2 and dp2[i] = (k - 1)
     * * (dp2[i - 2] + dp2[i - 1]) becomes d2 = (k - 1) * (d1 + d2). Moreover,
     * d1 needs to be set to the old d2, which is recorded in s. So we have d1 =
     * s.
     *
     * Finally, the return value dp1[n - 1] + dp2[n - 1] is just s + d2.
     *
     */
    public int numWays(int n, int k)
    {
        if (n < 2 || k == 0) {
            return n * k;
        }

        int s = k, d1 = k, d2 = k * (k - 1);

        for (int i = 2; i < n; i++) {
            s = d2;
            d2 = (k - 1) * (d1 + d2);
            d1 = s;
        }

        return s + d2;
    }
}
