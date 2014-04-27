public class candy {
    /**
     * O(n) time and O(n) space complexity.
     * 
     */
    public int calculate(int[] ratings) {
        int n = ratings.length;
        int[] candy = new int[n];

        for (int i = 0; i < candy.length; i++) {
            candy[i] = 1;
        }

        for (int i = 1; i < candy.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            /**
             * Filter out the case "candy[i] > candy[i + 1]" because the child at
             * position i is the summit and her candy number is higher than the
             * child at position (i + 1).
             */
            if (ratings[i] > ratings[i + 1] && candy[i] <= candy[i + 1]) {
                candy[i] = candy[i + 1] + 1;
            }
        }

        long result = 0;
        for (int j = 0; j < n; j++) {
            result += candy[j];
        }

        return (int) result;
    }

    /**
     * O(n) time and O(1) space complexity.
     * 
     */
    public int calculateImprov(int[] ratings) {
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