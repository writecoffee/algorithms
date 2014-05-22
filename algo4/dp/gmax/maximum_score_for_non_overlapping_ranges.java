package gmax;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a collection of segments, each segment have three values, the beginning point, the end
 * point and the score. Find a set of segments have the largest score but non of them is overlapped
 * with others.
 * 
 * {start point, end point, score}
 * 
 * For example:
 * 
 * input: {1,3,3}, {2,4,5}, {3,5,3}
 * 
 * output: {1,3,3}，{3,5,3}，
 * 
 */
public class maximum_score_for_non_overlapping_ranges {
    public static class Range {
        final int start, end;
        final int score;

        public Range(int _start, int _end, int _score) {
            start = _start;
            end = _end;
            score = _score;
        }
    }

    public ArrayList<Range> getOptimalRanges(Range[] ranges) {
        ArrayList<Range> result = new ArrayList<Range>();
        Arrays.sort(ranges, new Comparator<Range>() {
            @Override
            public int compare(Range a, Range b) {
                return a.end - b.end;
            }
        });

        int n = ranges.length;
        int[] dp = new int[ranges[n - 1].end + 1];

        for (int i = 0; i < n; ++i) {
            int start = ranges[i].start;
            int end = ranges[i].end;
            int score = ranges[i].score;

            int pre = i - 1;
            while (pre >= 0 && ranges[pre].end > start) {
                pre--;
            }

            int lMax = score + (pre >= 0 ? dp[ranges[pre].end] : 0);
            dp[end] = Math.max(dp[end], lMax);
            for (int j = i - 1; j >= 0 && ranges[j].end > start; --j) {
                dp[end] = Math.max(dp[end], dp[ranges[j].end]);
            }
        }

        System.out.println(dp[ranges[n - 1].end]);
        return result;
    }

    public static void main(String[] args) {
        new maximum_score_for_non_overlapping_ranges().getOptimalRanges(new Range[] {
                        new Range(1, 3, 3), new Range(2, 4, 5), new Range(3, 5, 3),
                        new Range(10, 11, 7) });
    }
}