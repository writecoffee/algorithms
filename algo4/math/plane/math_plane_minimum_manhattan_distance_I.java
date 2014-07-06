package plane;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * We know there are n points in the plane, find one of those points such that
 * the sum of Manhattan distance between this point and others is minimum.
 * 
 * [Difficulty] - Medium
 * [Source]     - google interview
 * [Similar]    - {@linkplain http://acm.tongji.edu.cn/problem?pid=30286}
 *                {@linkplain http://poj.org/problem?id=3269}
 *
 */
public class math_plane_minimum_manhattan_distance_I {
    private static class Point {
        private final int x, y;

        private Point(int _x, int _y) {
            x = _x;
            y = _y;
        }
    }

    /**
     * We can sort the array firstly based on the x coordinates. For the first element,
     * we know that the x distances for it and others should be the sum of all other 
     * x coordinates minus (n - 1) * x_1.
     * 
     * Now the key observation here is that every time we move onto the next element in
     * the sorted array, we can simply calculate the Manhattan distances by using this
     * formula:
     * 
     *     (i * x_i - lSum) + (rSum - (n - 1 - i) * x_i)
     * 
     * So we can have a running lSum and rSum which is used to record the sub-array sum
     * for [0 .. i) and [i + 1 .. n) respectively.
     * 
     * We can do the similar way for y coordinates and finally we put the x and y distances
     * to a hash table. We go through the point array again and get the result from hash
     * table forming the final minimum distance.
     * 
     */
    public static int findMinDist(Point[] points, int n) {
        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point a, Point b) {
                return a.x - b.x;
            }
        });

        int lSum = 0, rSum = 0;

        for (int i = 1; i < n; ++i) {
            rSum += points[i].x;
        }

        HashMap<Point, Integer> xDist = new HashMap<Point, Integer>();
        xDist.put(points[0], rSum - (n - 1) * points[0].x);

        for (int i = 1; i < n; ++i) {
            Point c = points[i], p = points[i - 1];
            lSum += p.x;
            rSum -= c.x;
            xDist.put(points[i], i * c.x - lSum + rSum - (n - 1 - i) * c.x);
        }

        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point a, Point b) {
                return a.y - b.y;
            }
        });

        lSum = 0;
        rSum = 0;

        for (int i = 1; i < n; ++i) {
            rSum += points[i].y;
        }

        HashMap<Point, Integer> yDist = new HashMap<Point, Integer>();
        yDist.put(points[0], rSum - (n - 1) * points[0].y);

        for (int i = 1; i < n; ++i) {
            Point c = points[i], p = points[i - 1];
            lSum += p.y;
            rSum -= c.y;
            yDist.put(points[i], i * c.y - lSum + rSum - (n - 1 - i) * c.y);
        }

        int gMin = Integer.MAX_VALUE;

        for (Point p : points) {
            gMin = Math.min(gMin, xDist.get(p) + yDist.get(p));
        }

        return gMin;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int n = Integer.parseInt(in.readLine());
        Point[] points = new Point[n];

        for (int i = 0; i < n; ++i) {
            String[] splits = in.readLine().split("\\s+");
            points[i] = new Point(Integer.parseInt(splits[0]), Integer.parseInt(splits[1]));
        }

        out.println(findMinDist(points, n));
        in.close();
        out.close();
    }
}