package partitioning;

import java.util.Arrays;

/**
 * On one line there are n houses. Give you an array of integer means the the
 * position of each house. Now you need to pick k position to build k post
 * office, so that the sum distance of each house to the nearest post office is
 * the smallest. Return the least possible sum of all distances between each
 * village and its nearest post office.
 *
 * Have you met this question in a real interview? Yes
 *
 * Example
 *
 * Given array a = [1,2,3,4,5], k = 2. return 3.
 *
 * Challenge
 *
 * Could you solve this problem in O(n^2) time ?
 *
 * [Source]     - {@linkplain http://www.lintcode.com/en/problem/post-office-problem/}
 * [Difficulty] - Hard
 *
 */
public class dp_pt_post_office_problem
{
    public int postOffice(int[] houses, int k)
    {
        int n = houses.length;
        Arrays.sort(houses);

        int[][] w = optDistances(n, houses);
        int[][] f = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            f[i][1] = w[1][i];
        }

        for (int nk = 2; nk <= k; nk++) {
            for (int i = nk; i <= n; i++) {
                f[i][nk] = Integer.MAX_VALUE;

                for (int j = 0; j < i; j++) {
                    f[i][nk] = Math.min(f[i][nk], f[j][nk - 1] + w[j + 1][i]);
                }
            }
        }

        return f[n][k];
    }

    private int[][] optDistances(int n, int[] houses)
    {
        int[][] w = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                int mid = (i + j) / 2;

                for (int k = i; k <= j; k++) {
                    w[i][j] += Math.abs(houses[k - 1] - houses[mid - 1]);
                }
            }
        }

        return w;
    }
}
