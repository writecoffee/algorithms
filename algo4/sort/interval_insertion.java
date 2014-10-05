import java.util.ArrayList;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the
 * intervals (merge if necessary).
 *
 * You may assume that the intervals were initially sorted according to their
 * start times.
 *
 * Example 1:
 *
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 *
 * Example 2:
 *
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as
 * [1,2],[3,10],[12,16].
 *
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 *
 * [Difficulty] - Hard
 * [Source]     - {@linkplain https://leetcode.com/problems/insert-interval/}
 * [Tag]        - $range$
 *
 */
public class interval_insertion
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

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval nxt)
    {
        int n = intervals.size();
        ArrayList<Interval> result = new ArrayList<Interval>();

        int i = 0;
        for (; i < n; ++i) {
            Interval c = intervals.get(i);

            if (c.end < nxt.start) {
                result.add(c);
            } else if (c.start > nxt.end) {
                break;
            } else {
                nxt.start = Math.min(c.start, nxt.start);
                nxt.end = Math.max(c.end, nxt.end);
            }
        }

        result.add(nxt);
        for (; i < n; ++i) {
            result.add(intervals.get(i));
        }

        return result;
    }
}
