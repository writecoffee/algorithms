import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array of size n, find all elements that appear more than ⌊
 * n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.
 *
 * Hint:
 *
 * How many majority elements could it possibly have?
 *
 * [Source]     - {@linkplain https://leetcode.com/problems/majority-element-ii/}
 * [Difficulty] - Medium
 *
 */
public class math_majority_element_II
{
    public List<Integer> majorityElement(int[] nums)
    {
        int count1 = 0,
            count2 = 0,
            candidate1 = -1,
            candidate2 = -1,
            threshold = nums.length / 3;

        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1++;
            } else if (count2 == 0) {
                candidate2 = num;
                count2++;
            } else {
                count2--;
                count1--;
            }
        }

        count1 = 0;
        count2 = 0;

        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }

        List<Integer> result = new ArrayList<>();

        if (count1 > threshold) {
            result.add(candidate1);
        }

        if (count2 > threshold) {
            result.add(candidate2);
        }

        return result;
    }
}
