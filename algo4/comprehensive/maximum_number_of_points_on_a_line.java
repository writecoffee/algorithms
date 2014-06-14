import java.util.HashMap;

/**
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight
 * line.
 * 
 * Be careful about NaN, Infinity and -Infinity.
 * 
 * [Difficulty] - Medium [Source] - {@linkplain https://oj.leetcode.com/problems/max-points-on-a-line/}
 * 
 */
public class maximum_number_of_points_on_a_line {
    public class Point {
        public final int x;
        public final int y;

        public Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    public int maxPoints(Point[] points) {
        int n = points.length;
        int gMax = 0;

        for (int i = 0; i < n; i++) {
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