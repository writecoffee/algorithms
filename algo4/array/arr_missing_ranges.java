import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array where the range of elements are [lower, upper]
 * inclusive, return its missing ranges.
 *
 * For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2",
 * "4->49", "51->74", "76->99"].
 *
 * [Difficulty]     - Medium
 * [Tediousness]    - Low
 * [Source]         - {@linkplain https://leetcode.com/problems/missing-ranges/}
 * [Tag]            - $range$
 *
 */
public class arr_missing_ranges
{
    public List<String> findMissingRanges(int[] nums, int lower, int upper)
    {
        List<String> result = new ArrayList<String>();
        int n = nums.length;

        if (n == 0) {
            buildRange(lower - 1, upper + 1, result);
            return result;
        }

        buildRange(lower - 1, nums[0], result);

        for (int i = 0; i < n - 1; ++i) {
            buildRange(nums[i], nums[i + 1], result);
        }

        buildRange(nums[n - 1], upper + 1, result);

        return result;
    }

    private void buildRange(int l, int r, List<String> result)
    {
        if (r - l == 2) {
            result.add(String.valueOf(r - 1));
        } else if (r - l > 2) {
            result.add((l + 1) + "->" + (r - 1));
        }
    }
}
