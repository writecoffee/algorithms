package geometry;

import java.util.Arrays;

/**
 * Given an array of integers, how many three numbers can be found in the array,
 * so that we can build an triangle whose three edges length is the three
 * numbers that we find?
 *
 * Have you met this question in a real interview? Yes
 *
 * Example
 *
 * Given array S = [3,4,6,7], return 3. They are:
 *
 * [3,4,6]
 * [3,6,7]
 * [4,6,7]
 *
 * Given array S = [4,4,4,4], return 4. They are:
 *
 * [4(1),4(2),4(3)]
 * [4(1),4(2),4(4)]
 * [4(1),4(3),4(4)]
 * [4(2),4(3),4(4)]
 *
 * [Difficulty] - Hard
 * [Source]     - {@linkplain http://www.lintcode.com/en/problem/triangle-count/}
 * [Tag]        - $two_pointers$
 *
 */
public class math_geo_triangle_count
{
    public int triangleCount(int S[])
    {
        int n = S.length;
        int count = 0;

        Arrays.sort(S);

        /**
         * We let smallest edge to be "a", such that a < b < c.
         *
         * We need to satisfy: a + b > c (I) then these three edges can form a triangle.
         *
         * Adjust the pointer positions to leave one and only one position shifting
         * for approaching (I).
         *
         */
        for (int i = 0; i < n; i++) {
            int c = S[i];

            for (int j = 0, k = i - 1; j < k;) {
                int a = S[j], b = S[k];

                if (a + b > c) {
                    count += k - j;
                    k--;
                } else {
                    j++;
                }
            }
        }

        return count;
    }
}
