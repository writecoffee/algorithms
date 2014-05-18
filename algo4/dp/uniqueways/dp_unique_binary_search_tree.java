package uniqueways;

public class dp_unique_binary_search_tree {
    /**
     * For a given number n, there will be 0 to n - 1 number of node(s)
     * in the left sub-tree. Let this number be k, and there will be
     * only n - 1 - k number of nodes in the right sub-tree.
     * 
     * R(k) = SUM_i from 0 to k - 1, R(i) * R(k - 1 - i)
     * R(0) = 1 
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int k = 1; k < n + 1; k++) {
            for (int j = 0; j < k; j++) {
                dp[k] += dp[j] * dp[k - j - 1];
            }
        }

        return dp[n];
    }
}