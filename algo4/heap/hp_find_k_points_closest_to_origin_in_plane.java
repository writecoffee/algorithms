import java.util.ArrayList;
import java.util.PriorityQueue;

public class hp_find_k_points_closest_to_origin_in_plane {
    class Point implements Comparable<Point> {
        final int x, y;

        Point(int _x, int _y) {
            x = _x;
            y = _y;
        }

        @Override
        public int compareTo(Point other) {
            return x * x + y * y - other.x * other.x - other.y * other.y;
        }
    }

    public ArrayList<Point> find(ArrayList<Point> points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<Point>();
        int n = points.size();

        for (int i = 0; i < k; ++i) {
            pq.add(points.get(i));
        }

        for (int i = k; i < n; ++i) {
            Point c = points.get(i);

            if (pq.peek().compareTo(c) > 0) {
                pq.poll();
                pq.add(c);
            }
        }

        return new ArrayList<Point>(pq);
    }
}