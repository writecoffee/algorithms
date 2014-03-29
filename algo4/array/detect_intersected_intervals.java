import java.util.Arrays;
import java.util.Comparator;

public class detect_intersected_intervals {
    class Interval {
        int start;
        int end;
    }

    public class MyInterval {
        public final Interval interval;
        public final int index;

        MyInterval(final Interval _interval, final int _index) {
            interval = _interval;
            index = _index;
        }
    }

    public void intersected(Interval[] intervals, boolean[] isIntersected) {
        int n = intervals.length;

        if (n == 0) {
            return;
        }

        MyInterval[] myIntervals = new MyInterval[n];
        for (int i = 0; i < n; ++i) {
            myIntervals[i] = new MyInterval(intervals[i], i);
        }

        Arrays.sort(myIntervals, new Comparator<MyInterval>() {
            @Override
            public int compare(MyInterval l, MyInterval r) {
                return l.interval.start - r.interval.start;
            }
        });

        int iMaxEnd = 0;
        isIntersected[myIntervals[0].index] = false;

        for (int i = 1; i < n; ++i) {
            Interval interval = myIntervals[i].interval;
            Interval intervalMaxEnd = myIntervals[iMaxEnd].interval;
            int index = myIntervals[i].index;
            int indexMaxEnd = myIntervals[iMaxEnd].index;

            if (interval.start <= intervalMaxEnd.end) {
                isIntersected[index] = true;
                isIntersected[indexMaxEnd] = true;
            }

            if (interval.end > intervalMaxEnd.end) {
                iMaxEnd = i;
            }
        }
    }
}