package uniqueways;

public class dp_unique_binary_trees_given_preorder_postorder_traversals {
    /**
     * Pre-order： [1, 2]
     * Post-order：[2, 1]
     * 
     *    1       1
     *   /         \
     *  2           2
     *  
     * result: 2
     *
     * Pre-order： [1, 2, 3]
     * Post-order：[2, 3, 1]
     * 
     *    1 
     *   / \ 
     *  2   3
     *  
     * result: 1
     *  
     */
    public int countValidTree(int[] preorder, int[] postorder) {
        if (preorder.length != postorder.length) {
            return 0;
        }

        int n = preorder.length;
        return explore(preorder, 0, postorder, 0, n);
    }

    private int explore(int[] preorder, int i, int[] postorder, int j, int n) {
        if (n == 0) {
            return 1;
        }

        if (preorder[i] != postorder[j + n - 1]) {
            return 0;
        }

        int count = 0;
        for (int k = 0; k < n; k++) {
            int l = explore(preorder, i + 1, postorder, j, k);
            int r = explore(preorder, i + 1 + k, postorder, j + k, n - 1 - k);
            count += l * r;
        }

        return count;
    }

    public static int countValidTreeDP(int[] preorder, int[] postorder) {
        if (preorder.length != postorder.length) {
            return 0;
        }

        int n = preorder.length;
        int[][][] dp = new int[n + 1][n + 1][n + 1];

        for (int k = 0; k <= n; k++) {
            for (int i = 0; i <= n - k; i++) {
                for (int j = 0; j <= n - k; j++) {
                    if (k == 0) {
                        dp[k][i][j] = 1;
                    } else if (preorder[i] != postorder[j + k - 1]) {
                        dp[k][i][j] = 0;
                    } else {
                        for (int l = 0; l < k; l++) {
                            dp[k][i][j] += dp[l][i + 1][j] * dp[k - 1 - l][i + 1 + l][j + l];
                        }
                    }
                }
            }
        }

        return dp[n][0][0];
    }
}