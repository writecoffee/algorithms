package plane;

import java.util.HashMap;
import java.util.Map;

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
     * The idea is to generate all possible point pairs where <a, b> is equivalent to <b, a>.
     * We generate slope from (b.y - a.y) / (b.x - a.x) and put it into a counter map.
     *
     * Question: Why we let j = i + 1, not start from 0?
     *
     * The problem can be turned into finding whether we ignored a line which cover the most
     * and some of the points are in the previous section (index <= i). If that is the case,
     * we must have calculated before because of transitiveness
     *
     */
    public int maxPoints(Point[] points)
    {
        int n = points.length;
        int gMax = 0;

        for (int i = 0; i < n - gMax; i++) {
            Map<Double, Integer> h = new HashMap<>();
            Point p1 = points[i];
            int lMax = 1;
            int samePoint = 0;

            for (int j = i + 1; j < n; j++) {
                Point p2 = points[j];
                double slope = Double.POSITIVE_INFINITY;

                if (p1.x == p2.x && p1.y == p2.y) {
                    samePoint++;
                    continue;
                }

                if (p1.x != p2.x) {
                    slope = 0.0 + 1.0 * (p2.y - p1.y) / (p2.x - p1.x);
                }

                Integer v = h.get(slope);
                if (v == null) {
                    v = 1;
                }
                v++;

                lMax = Math.max(lMax, v);
                h.put(slope, v);
            }

            gMax = Math.max(gMax, samePoint + lMax);
        }

        return gMax;
    }
}
