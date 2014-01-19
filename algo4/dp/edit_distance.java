public class edit_distance {
    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] table = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 1; i < m + 1; i++) {
            table[i][0] = i;
        }

        for (int i = 1; i < n + 1; i++) {
            table[0][i] = i;
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (word2.charAt(j - 1) == word1.charAt(i - 1)) {
                    table[i][j] = table[i - 1][j - 1];
                } else {
                    table[i][j] = Math.min(Math.min(table[i][j - 1],
                                                    table[i - 1][j]),
                                                    table[i - 1][j - 1]) + 1;
                }
            }
        }

        return table[m][n];
    }

    public static int minDistanceImprov(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] table = new int[2][n + 1];

        for (int i = 1; i < n + 1; i++) {
            table[0][i] = i;
        }

        for (int i = 1; i < m + 1; i++) {
            table[i % 2][0] = i;

            for (int j = 1; j < n + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    table[i % 2][j] = table[(i - 1) % 2][j - 1];
                } else {
                    table[i % 2][j] = Math.min(Math.min(table[i % 2][j - 1],
                                                        table[(i - 1) % 2][j]),
                                                        table[(i - 1) % 2][j - 1]) + 1;
                }
            }
        }

        return table[m % 2][n];
    }

    public static void main(String[] args) {
        System.out.println(minDistanceImprov("", ""));
        System.out.println(minDistanceImprov("a", "a"));
        System.out.println(minDistanceImprov("", "a"));
        System.out.println(minDistanceImprov("b", "a"));
    }
}