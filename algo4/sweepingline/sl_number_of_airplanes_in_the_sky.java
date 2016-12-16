import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given an interval list which are flying and landing time of the flight. How
 * many airplanes are on the sky at most?
 *
 * Example
 *
 * For interval list [[1,10],[2,3],[5,8],[4,7]], return 3
 *
 * Note
 *
 * If landing and flying happens at the same time, we consider landing should
 * happen at first.
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain http://www.lintcode.com/en/problem/number-of-airplanes-in-the-sky/}
 *
 */
public class sl_number_of_airplanes_in_the_sky
{
    public class Interval
    {
        int start, end;

        Interval(int start, int end)
        {
            this.start = start;
            this.end = end;
        }
    }

    public static class Point
    {
        int x;
        int isLanding;

        Point(int x, int isLanding)
        {
            this.x = x;
            this.isLanding = isLanding;
        }
    }

    public int countOfAirplanes(List<Interval> airplane)
    {
        List<Point> points = new ArrayList<>();

        for (Interval interval : airplane) {
            points.add(new Point(interval.start, 0));
            points.add(new Point(interval.end, 1));
        }

        Collections.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2)
            {
                if (o1.x == o2.x) {
                    return o2.isLanding - o1.isLanding;
                }

                return o1.x - o2.x;
            }
        });

        int result = 0;
        int count = 0;
        for (Point p : points) {
            if (p.isLanding == 0) {
                count++;
            } else {
                count--;
            }

            result = Math.max(result, count);
        }

        return result;
    }
}
