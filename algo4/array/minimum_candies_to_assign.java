/**
 * There are N children standing in a line. Each child is assigned a rating value.
 * 
 * You are giving candies to these children subjected to the following requirements:
 * 
 *    - Each child must have at least one candy.
 *    - Children with a higher rating get more candies than their neighbors.
 * 
 * What is the minimum candies you must give?
 * 
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/candy/}
 *
 */
public class minimum_candies_to_assign {
    public int calculate(int[] ratings) {
        int n = ratings.length, result = 0;
        int[] candy = new int[n];

        for (int i = 0; i < n; i++) {
            candy[i] = i > 0 && ratings[i] > ratings[i - 1] ? candy[i] = candy[i - 1] + 1 : 1;
        }

        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && candy[i] <= candy[i + 1]) {
                candy[i] = candy[i + 1] + 1;
            }

            result += i == n - 2 ? candy[i] + candy[i + 1] : candy[i];
        }

        return result;
    }

    public int calculateImproved(int[] ratings) {
        int n = ratings.length;

        if (n == 0) {
            return 0;
        }

        int result = 0;
        int i = 1, j = 0, k = 0;
        int intersectCnt = 0;

        for (; i < n; ++i) {
            if (ratings[i] > ratings[i - 1] && i - 1 == k) {
                k = i;
            } else if (ratings[i] > ratings[i - 1]) {
                result += computeSlope(i - 1, j, k);
                j = i - 1;
                k = i;
                intersectCnt++;
            } else if (ratings[i] == ratings[i - 1]) {
                result += computeSlope(i - 1, j, k);
                j = i;
                k = i;
            }
        }
        result += computeSlope(n - 1, j, k) - intersectCnt;

        return result;
    }

    private int computeSlope(int decEnd, int incBeg, int climax) {
        int l = climax - incBeg;
        int r = decEnd - climax;
        int sum = 0;

        for (int i = 0, j = 1; i < l; ++i, ++j) {
            sum += j;
        }

        for (int i = 0, j = 1; i < r; ++i, ++j) {
            sum += j;
        }

        return sum + Math.max(l, r) + 1;
    }
}