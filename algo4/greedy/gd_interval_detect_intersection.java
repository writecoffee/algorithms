import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of intervals, determine if the interval is intersected with any
 * other interval or not.
 *
 * [Source]     - itint5
 * [Difficulty] - Hard
 * [Tag]        - $range$
 *
 */
public class gd_interval_detect_intersection
{
    private class Interval
    {
        int start;
        int end;
    }

    private class MyInterval extends Interval
    {
        public final int index;

        MyInterval(int _start, int _end, final int _index)
        {
            start = _start;
            end = _end;
            index = _index;
        }
    }

    public void intersected(Interval[] intervals, boolean[] isIntersected)
    {
        int n = intervals.length;

        MyInterval[] myIntervals = new MyInterval[n];
        for (int i = 0; i < n; ++i) {
            myIntervals[i] = new MyInterval(intervals[i].start, intervals[i].end, i);
        }

        Arrays.sort(myIntervals, new Comparator<MyInterval>() {
            @Override
            public int compare(MyInterval a, MyInterval b)
            {
                return a.start - b.start;
            }
        });

        for (int i = 0; i < n - 1; ++i) {
            MyInterval a = myIntervals[i], b = myIntervals[i + 1];

            if (a.start == b.start) {
                isIntersected[a.index] = true;
                isIntersected[b.index] = true;
                b.end = Math.max(a.end, b.end);
            } else if (a.end >= b.start) {
                isIntersected[a.index] = true;
                isIntersected[b.index] = true;
                b.end = Math.max(a.end, b.end);
            }
        }
    }
}
