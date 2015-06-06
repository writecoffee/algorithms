import java.util.ArrayList;

/**
 * 
 * [Tag]        - $range$
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