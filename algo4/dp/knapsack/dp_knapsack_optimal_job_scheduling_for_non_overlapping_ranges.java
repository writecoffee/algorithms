package knapsack;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.google.common.collect.Lists;

/**
 * Given a collection of segments, each segment have three values, the beginning
 * point, the end point and the score. Find a set of segments have the largest
 * score but non of them is overlapped with others.
 *
 * {start point, end point, score}
 *
 * For example:
 *
 * input: {1,3,3}, {2,4,5}, {3,5,3}
 *
 * output: {1,3,3}，{3,5,3}，
 *
 * [Difficulty] - Hard
 * [Source]     - facebook interview
 *
 */
public class dp_knapsack_optimal_job_scheduling_for_non_overlapping_ranges
{
    public static class RangeBuilder
    {
        private List<Range> ranges = Lists.newArrayList();

        public RangeBuilder addRange(int start, int end, int score)
        {
             ranges.add(new Range(start, end, score));
             return this;
        }

        public Range[] toSortedArray()
        {
            Range[] result = new Range[ranges.size()];
            ranges.toArray(result);

            Arrays.sort(result, new Comparator<Range>() {
                @Override
                public int compare(Range a, Range b)
                {
                    return Integer.compare(a.end, b.end);
                }
            });

            ranges.clear();
            return result;
        }
    }

    public static class Range
    {
        final int start, end, score;

        public Range(int _start, int _end, int _score)
        {
            start = _start;
            end = _end;
            score = _score;
        }
    }

    /**
     * Let's define:
     *
     * P[i]: for interval i, get the biggest ending point which is smaller than starting
     *       point of interval i.
     *
     * D[i]: Max { weight[i] + D[P[i]],
     *             D[i - 1]
     *           }
     *
     *       which stands for the maximum value taking jobs range [0 .. i], it could be
     *       either the case job i is taken or the case job i is not.
     *
     */
    public static int getOptimalResult(Range[] ranges)
    {
        int n = ranges.length;
        int[] dp = new int[n + 1];

        for (int i = 1, j = 0; j < n; ++i, ++j) {
            dp[i] = Math.max(dp[findClosest(ranges, j, ranges[j].start)] + ranges[j].score,
                             dp[i - 1]);
        }

        return dp[n];
    }

    private static int findClosest(Range[] ranges, int j, int start)
    {
        for (int i = 0; i < j; ) {

            int mid = (i + j) / 2;
            int midEnd = ranges[mid].end;

            if (midEnd <= start) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }

        return j;
    }

    public static void main(String[] args)
    {
        RangeBuilder builder = new RangeBuilder();
        builder.addRange(1, 3, 3)
               .addRange(2, 4, 5)
               .addRange(3, 5, 3);

        assert getOptimalResult(builder.toSortedArray()) == 6;

        builder.addRange(1, 3, 3)
               .addRange(3, 4, 5)
               .addRange(2, 4, 9)
               .addRange(6, 11, 7)
               .addRange(3, 6, 3);

        assert getOptimalResult(builder.toSortedArray()) == 16;
    }
}
