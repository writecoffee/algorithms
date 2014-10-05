/**
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 *
 * [Difficulty] - Easy
 * [Source]     - {@linkplain https://leetcode.com/problems/majority-element/}
 *
 */
public class math_majority_element
{
    public int majorityElement(int[] nums)
    {
        int counter = 0,
            candidate = -1;

        for (int num : nums) {
            if (counter == 0) {
                candidate = num;
                counter++;
            } else if (candidate != num) {
                counter--;
            } else {
                counter++;
            }
        }

        return candidate;
    }
}
