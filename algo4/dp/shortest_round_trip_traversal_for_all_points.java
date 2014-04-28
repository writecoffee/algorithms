public class shortest_round_trip_traversal_for_all_points {
    class Point {
        int x, y;

        Point(int _x, int _y) {
            x = _x;
            y = _y;
        }
    }

    private double dist(Point p1, Point p2) {
        int x = p1.x - p2.x;
        int y = p1.y - p2.y;
        return Math.sqrt(x * x + y * y);
    }

    /**
     * dp[k][i]: two disjoint bitonic paths, one from point(0) to point(i) and, the other from
     *           point(0) to point(j). When i = k we have a minimum cost bitonic tour through
     *           the first i nodes. When i = k = n we have a minimum cost bitonic tour through
     *           all n points.
     *           
     *  We are filling the table from top to the bottom, from left to the right, and thus we can
     *  remove duplicate paths (i, k swapped).
     * 
     */
    public double minDist(Point[] points) {
        int n = points.length;
        double[][] dp = new double[n][n];

        for (int k = 0; k < n; ++k) {
            for (int i = k; i < n; ++i) {
                /**
                 * Case 1: i > k + 1. The minimum cost disjoint paths from 1 to i and from 1 to k
                 * must contain the edge (i - 1, i).
                 * 
                 * Case 2: i == k. The edge ending in i comes from u, 0 <= u < k.
                 * 
                 * Case 3: i == k + 1. The two edges entering k + 1 must come from k and from some
                 * u, 0 <= u <= k.
                 * 
                 */
                if (i - k > 1) {
                    dp[k][i] = dp[k][i - 1] + dist(points[i - 1], points[i]);
                } else {
                    double minD = dp[0][k] + dist(points[0], points[i]);

                    for (int u = 1; u < k; u++) {
                        minD = Math.min(minD, dp[u][k] + dist(points[u], points[i]));
                    }

                    dp[k][i] = minD;
                }
            }
        }

        return dp[n - 1][n - 1];
    }
}