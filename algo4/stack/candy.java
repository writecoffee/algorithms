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
     * O(n) time and O(1) space complexity
     * 
     */
    public static int calculateImprov(int[] ratings) {
        int n = ratings.length;

        if (n == 0) {
            return 0;
        }

        int j = 0;
        int jVal = 1;
        int last = 1;
        long result = 1;

        for (int i = 1; i < n; ++i) {
            if (ratings[i] > ratings[i - 1]) {
                j = i;
                jVal = last = last + 1;
                result += jVal;
            } else if (ratings[i] == ratings[i - 1]) {
                last = 1;
                result += 1;
                j = i;
                jVal = 1;
            } else {
                if (last == 1) {
                    if (i - j == jVal) {
                        jVal += 1;
                        result += i - j + 1;
                    } else {
                        result += i - j;
                    }
                } else {
                    last = 1;
                    result++;
                }
            }
        }

        return (int) result;
    }

    public static void main(String[] args) {
        System.out.println(calculateImprov(new int[] { 1, 3, 4, 2, 1, 9 }));
    }
}