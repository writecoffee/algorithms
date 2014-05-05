import java.util.Arrays;
import java.util.Comparator;

public class concat_num_array {
    /**
     * For ["54", "546", "548", "60"]
     * 
     * The largest number is "6054854654" after concatenation.
     * 
     */
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