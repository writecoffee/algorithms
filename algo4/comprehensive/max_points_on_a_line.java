import java.util.Collections;
import java.util.HashMap;

public class max_points_on_a_line {
    static class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    public static int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }

        HashMap<Double, Integer> h = new HashMap<Double, Integer>();
        int n = points.length;
        int gMax = 1;

        for (int i = 0; i < n; i++) {
            h.clear();
            h.put((double) Integer.MIN_VALUE, 1);

            int dup = 0;
            for (int j = i + 1; j < n; j++) {
                if (points[j].x == points[i].x && points[j].y == points[i].y) {
                    dup++;
                    continue;
                }

                double slope = points[j].x - points[i].x == 0 ?
                               Integer.MAX_VALUE :
                               0.0 + (double) (points[j].y - points[i].y) / (double) (points[j].x - points[i].x);

                if (h.containsKey(slope)) {
                    h.put(slope, h.get(slope) + 1);
                } else {
                    h.put(slope, 2);
                }
            }

            int lMax = Collections.max(h.values()) + dup;
            gMax = lMax > gMax ? lMax : gMax;
        }

        return gMax;
    }

    public static void main(String[] args) {
        System.out.println(maxPoints(new Point[] { new Point(0, 0), new Point(1, 1), new Point(1, -1) }));
        System.out.println(maxPoints(new Point[] { new Point(2, 3), new Point(3, 3), new Point(-5, 3) }));
    }
}