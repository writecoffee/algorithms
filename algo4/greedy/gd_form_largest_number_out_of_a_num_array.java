import java.util.Arrays;
import java.util.Comparator;

/**
 * There are n non-negative numbers in the input array, concatenate these numbers
 * to form a largest integer.
 *
 * For example:
 *
 * ["54", "546", "548", "60"]
 *
 * The largest number is "6054854654" after concatenation.
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain http://www.itint5.com/oj/#45}
 *                {@linkplain https://leetcode.com/problems/largest-number/}
 *
 */
public class gd_form_largest_number_out_of_a_num_array {
    public String biggestNum(String[] nums)
    {
        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String a, String b)
            {
                return new String(b + a).compareTo(new String(a + b));
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String s : nums) {
            sb.append(s);
        }

        return sb.toString();
    }

    public String largestNumber(int[] nums)
    {
        int n = nums.length;
        String[] numsStr = new String[n];

        for (int i = 0; i < n; ++i) {
            numsStr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numsStr, new Comparator<String>() {
            @Override
            public int compare(String a, String b)
            {
                String v1 = a + b,
                       v2 = b + a;

                return v2.compareTo(v1);
            }
        });

        StringBuilder sb = new StringBuilder();
        int i = 0;

        for (; i < n - 1 && numsStr[i].equals("0") && numsStr[i + 1].equals("0"); ++i) {
        }

        for (; i < n; ++i) {
            sb.append(numsStr[i]);
        }

        return sb.toString();
    }
}
