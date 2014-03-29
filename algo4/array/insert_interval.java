import java.util.ArrayList;

public class insert_interval {
    public class Interval {
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

    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        int n = intervals.size();

        int i = 0;
        for (; i < n; i++) {
            Interval c = intervals.get(i);

            if (c.end < newInterval.start) {
                result.add(c);
            } else if (c.start > newInterval.end) {
                break;
            } else {
                newInterval.start = Math.min(c.start, newInterval.start);
                newInterval.end = Math.max(c.end, newInterval.end);
            }
        }

        result.add(newInterval);
        while (i < n) {
            result.add(intervals.get(i));
            i++;
        }

        return result;
    }
}
