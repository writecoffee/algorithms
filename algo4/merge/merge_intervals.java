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

    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        int N = intervals.size();
        ArrayList<Interval> result = new ArrayList<Interval>();

        if (N == 0) {
            return result;
        }

        Collections.sort(intervals, Int_compare);

        Interval currInterval = intervals.get(0);
        if (N == 1) {
            result.add(currInterval);
            return result;
        }

        for (int i = 0; i < N; i++) {
            Interval nextInterval = intervals.get(i);
            if (nextInterval.end < currInterval.start || nextInterval.start > currInterval.end) {
                result.add(currInterval);
                currInterval = nextInterval;
            } else {
                currInterval.start = Math.min(currInterval.start, nextInterval.start);
                currInterval.end = Math.max(currInterval.end, nextInterval.end);
            }
        }

        result.add(currInterval);
        return result;
    }
    
    static final Comparator<Interval> Int_compare = new Comparator<Interval>() {
        public int compare(Interval i, Interval j) {
            return new Integer(i.start).compareTo(new Integer(j.start));
        }
    };
    
    static ArrayList<Interval> testcase = new ArrayList<merge_intervals.Interval>();
    static {
        testcase.add(new Interval(1, 3));
        testcase.add(new Interval(2, 6));
    }

    public static void main(String[] args) {
        merge(testcase);
    }
}
