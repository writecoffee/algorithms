public class shortest_round_trip_traversal_for_all_points {
    static class Point {
        int x, y;

        Point(int _x, int _y) {
            x = _x;
            y = _y;
        }
    }

    private static double dist(Point p1, Point p2) {
        int x = p1.x - p2.x;
        int y = p1.y - p2.y;
        return Math.sqrt(x * x + y * y);
    }

    /**
     * dp[i][j]: two shortest paths stem from point(0) and end at point(i) and point(j) respectively,
     *           where all nodes within range [0, j] have been explored in the paths.
     * 
     */
    public static double minDist(Point[] points) {
        int n = points.length;
        double[][] dp = new double[n][n];

        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                /**
                 * Path-j has at least 2-hop larger x position than path-i, then path-j
                 * can be directly computed 1-hop further from dp[i][j - 1].
                 * 
                 * So dp[0][j] can be interpreted as a path from point(0) to point(j) having
                 * explored all intermediate points.
                 * 
                 */
                if (j - i > 1) {
                    dp[i][j] = dp[i][j - 1] + dist(points[j - 1], points[j]);
                } else {
                    double minD = dp[0][i] + dist(points[0], points[j]);

                    for (int k = 1; k < i; k++) {
                        minD = Math.min(minD, dp[k][i] + dist(points[k], points[j]));
                    }

                    dp[i][j] = minD;
                }
            }
        }

        return dp[n - 1][n - 1];
    }

    public static void main(String[] args) {
        minDist(new Point[] { new Point(0, 0), new Point(10, -5), new Point(30, 40), new Point(31, 0) });
    }
}