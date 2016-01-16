/**
 * Given an unsorted array A, range index i and j (i <= j), return the minimum element
 * from A[i .. j].
 *
 * [Difficulty] - Easy
 * [Source]		- Made up by myself
 * [Tag]        - $range$
 *
 */
public class process_range_query_determine_minimum {
	private int[][] dp;

    public int[][] preprocess(int[] array) {
		int n = array.length;
		int[][] dp = new int[n][n];

		for (int i = 0; i < n; ++i)	{
			dp[i][i] = array[i];

			for (int j = i + 1; j < n; ++j) {
				dp[i][j] = Math.min(dp[i][j - 1], array[j]);
			}
		}

		return dp;
	}

	public int findRangeMin(int i, int j) {
		return dp[i][j];
	}
}
