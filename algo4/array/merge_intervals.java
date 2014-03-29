import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class merge_intervals {
    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval l, Interval r) {
                return l.start - r.start;
            }
        });

        int n = intervals.size();
        ArrayList<Interval> result = new ArrayList<Interval>();

        if (n == 0) {
            return result;
        }

        Interval newInterval = new Interval(intervals.get(0).start, intervals.get(0).end);

        if (n == 1) {
            result.add(newInterval);
            return result;
        }

        for (int i = 1; i < n; ++i) {
            if (newInterval.end < intervals.get(i).start) {
                result.add(newInterval);
                newInterval = new Interval(intervals.get(i).start, intervals.get(i).end);
            } else {
                newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
            }
        }
        result.add(newInterval);

        return result;
    }
}
