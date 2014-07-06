package plane;

import java.util.HashMap;

/**
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight
 * line.
 * 
 * Be careful about NaN, Infinity and -Infinity.
 * 
 * [Difficulty] - Hard
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/max-points-on-a-line/}
 * 
 */
public class math_plane_maximum_number_of_points_on_a_line {
    public class Point {
        public final int x;
        public final int y;

        public Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    /**
     * A naive thought is that any two points in the plane can form a line. So we can choose
     * (n + 1) * n / 2 number of possible edges to calculate their slope k. For each k we can
     * add up the number of edges. Let the number of points be m, we can derive that
     * (m + 1) * m / 2 = k and hence eventually we can derive m from the maximum k.
     * 
     * However, there would be case when point a and point b can coincide then we can not
     * determine which k it belongs to.
     * 
     * Now, each time we can pick a specific point in the point set and iterate through other
     * points in the set to find the maximum number of points share the same line. It's just
     * (n + 1) * n / 2 number of pairs.
     * 
     * Question: Why we let j = i + 1, not start from 0?
     * 
     * The problem becomes whether we ignored a line which cover the most and some of the points
     * are in the previous section (index <= i). If that is the case, we must have calculated
     * before because of transitiveness.
     * 
     */
    public int maxPoints(Point[] points) {
        int n = points.length, gMax = 0;

        for (int i = 0; i < n - gMax; i++) {
            HashMap<Double, Integer> h = new HashMap<Double, Integer>();
            int lMax = 1, nan = 0;

            for (int j = i + 1; j < n; j++) {
                if (points[j].x == points[i].x && points[j].y == points[i].y) {
                    nan++;
                } else {
                    double dx = points[j].x - points[i].x, dy = points[j].y - points[i].y;
                    double slope = dx == 0.0 ? Double.POSITIVE_INFINITY : 0.0 + dy / dx;

                    if (!h.containsKey(slope)) {
                        h.put(slope, 1);
                    }

                    lMax = Math.max(lMax, h.put(slope, h.get(slope) + 1) + 1);
                }
            }

            gMax = Math.max(lMax + nan, gMax);
        }

        return gMax;
    }
}