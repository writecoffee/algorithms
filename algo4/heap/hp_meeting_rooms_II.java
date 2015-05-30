import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

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
public class hp_meeting_rooms_II
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

    public int minMeetingRooms(Interval[] intervals)
    {
        int n = intervals.length;

        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b)
            {
                return a.start - b.start;
            }
        });

        Queue<Interval> pq = new PriorityQueue<Interval>(new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b)
            {
                return a.end - b.end;
            }
        });

        int gMax = 0;
        int occupied = 0;

        for (int i = 0; i < n; i++) {
            Interval c = intervals[i];
            int returned = 0;

            while (!pq.isEmpty() && pq.peek().end <= c.start) {
                pq.poll();
                returned++;
            }

            pq.offer(c);

            occupied = occupied - returned + 1;
            gMax = Math.max(gMax, occupied);
        }

        return gMax;
    }
}
