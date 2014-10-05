import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array without duplicates, return the summary of its
 * ranges.
 *
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 *
 * [Difficulty] - Easy
 * [Source]     - {@linkplain https://leetcode.com/problems/summary-ranges/}
 *
 */
public class tp_summary_ranges
{
    public List<String> summaryRanges(int[] nums)
    {
        int n = nums.length, i = 0;
        List<String> result = new ArrayList<String>();

        for (int j = 1; j < n; ++j) {
            if (nums[j] - nums[j - 1] != 1) {
                result.add(convert(nums, i, j - 1));
                i = j;
            }
        }

        if (i < n) {
            result.add(convert(nums, i, n - 1));
        }

        return result;
    }

    private String convert(int[] nums, int start, int end)
    {
        if (end == start) {
            return Integer.toString(nums[start]);
        } else {
            return nums[start] + "->" + nums[end];
        }
    }
}
