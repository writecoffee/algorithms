import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of [a,b] intervals on the number line, find the longest ORDERED
 * sequence of (a subset of) the intervals such that each consecutive interval
 * is nested inside the previous one. "Nested" means this: If interval X is
 * nested inside Y, then Y.a < X.a and X.b < Y.b.
 *
 * Example:
 *
 * Given: [[1,10], [3,4], [2,9], [3,8], [4,5], [11,12]]
 * Return: [[1,10], [2,9], [3,8], [4,5]]
 *
 * [Source]     - twitter interview
 * [Difficulty] - Hard
 *
 */
public class gd_interval_longest_consecutive_sequence_I
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

        int n = intervals.size();
        Interval last = intervals.get(0);
        for (int i = 1; i < n; i++) {
            Interval c = intervals.get(i);

            if (isSameStart(last, c)) {
                last.end = Math.max(c.end, last.end);
            } else if (isNested(last, c)) {
                continue;
            } else if (isConsecutive(last, c)) {
                result.add(last);
                last = c;
            }
        }
        result.add(last);

        return result;
    }

    private boolean isSameStart(Interval last, Interval c)
    {
        return last.start == c.start;
    }

    private boolean isConsecutive(Interval last, Interval c)
    {
        return last.start + 1 == c.start;
    }

    private boolean isNested(Interval last, Interval c)
    {
        return last.start < c.start && last.end > c.end;
    }
}
