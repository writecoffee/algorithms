import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of meeting time intervals consisting of start and end times
 * [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all
 * meetings.
 *
 * For example,
 *
 * Given [[0, 30],[5, 10],[15, 20]],
 *
 * return false.
 *
 * [Difficulty] - Easy
 * [Source]     - {@linkplain https://leetcode.com/problems/meeting-rooms/}
 * [Tag]        - $interval$
 *
 */
public class hp_meeting_rooms_I
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

    public boolean canAttendMeetings(Interval[] intervals)
    {
        int n = intervals.length;

        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b)
            {
                return a.start - b.start;
            }
        });

        for (int i = 0; i < n - 1; i++) {
            if (intervals[i].end > intervals[i + 1].start) {
                return false;
            }
        }

        return true;
    }
}
