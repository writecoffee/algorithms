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
 * 
 */
public class gd_concat_num_array {
    public String biggestNum(String[] nums) {
        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return new String(b + a).compareTo(new String(a + b));
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String s : nums) {
            sb.append(s);
        }

        return sb.toString();
    }
}