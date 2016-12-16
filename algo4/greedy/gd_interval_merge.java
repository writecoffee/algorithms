import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * For example, Given [1,3],[2,6],[8,10],[15,18], return [1,6],[8,10],[15,18].
 *
 * [Difficulty] - Hard
 * [Source]     - {@linkplain https://leetcode.com/problems/merge-intervals/}
 * [Tag]        - $range$
 */
public class gd_interval_merge
{
    public class Interval
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

    public List<Interval> merge(List<Interval> intervals)
    {
        List<Interval> result = new ArrayList<>();

        if (intervals.size() == 0) {
            return result;
        }

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b)
            {
                return a.start - b.start;
            }
        });

        int n = intervals.size();
        Interval last = intervals.get(0);
        for (int i = 1; i < n; i++) {
            Interval nxt = intervals.get(i);

            if (last.end < nxt.start) {
                result.add(last);
                last = nxt;
            } else {
                last.end = Math.max(last.end, nxt.end);
            }
        }
        result.add(last);

        return result;
    }
}
