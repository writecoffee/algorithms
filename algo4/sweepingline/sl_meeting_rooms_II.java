package sweepingline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given an array of meeting time intervals consisting of start and end times
 * [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms
 * required.
 *
 * For example,
 *
 * Given [[0, 30],[5, 10],[15, 20]],
 *
 * return 2.
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://leetcode.com/problems/meeting-rooms/}
 * [Tag]        - $interval$
 *
 */
public class sl_meeting_rooms_II
{
    public static class Interval
    {
        int start;
        int end;

        Interval()
        {
            start = 0;
            end = 0;
        }

        Interval(int s, int e)
        {
            start = s;
            end = e;
        }
    }

    public static class Point
    {
        int ts;
        int isStart;

        Point(int t, int startIndicator)
        {
            ts = t;
            isStart = startIndicator;
        }
    }

    public int minMeetingRooms(Interval[] intervals)
    {
        List<Point> points = new ArrayList<>();
        for (Interval intv : intervals) {
            points.add(new Point(intv.start, 1));
            points.add(new Point(intv.end, -1));
        }

        Collections.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2)
            {
                if (o1.ts == o2.ts) {
                    return o1.isStart - o2.isStart;
                }

                return o1.ts - o2.ts;
            }
        });

        int gMax = 0;
        int occupied = 0;

        for (Point c : points) {
            if (c.isStart == 1) {
                occupied++;
            } else {
                occupied--;
            }

            gMax = Math.max(gMax, occupied);
        }

        return gMax;
    }
}
