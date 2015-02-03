import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a TwoSum class. It should support the following
 * operations: add and find.
 *
 * add - Add the number to an internal data structure. find - Find if there
 * exists any pair of numbers which sum is equal to the value.
 *
 * For example,
 *
 * add(1); add(3); add(5);
 *
 * find(4) -> true
 *
 * find(7) -> false
 *
 * [Difficulty] - Easy
 * [Source]     - {@linkplain https://leetcode.com/problems/two-sum-iii-data-structure-design/}
 *
 */
public class two_sum_III_data_structure_design
{
    Map<Integer, Integer> h = new HashMap<Integer, Integer>();

    /**
     * add – O(1) runtime, find – O(n) runtime, O(n) space – Store input in hash
     * table:
     *
     * A simpler approach is to store each input into a hash table with the
     * input as key and its count as value. To find if a pair sum exists, just
     * iterate through the hash table in O(n) runtime. Make sure you are able to
     * handle duplicates correctly
     */
    public void add(int number)
    {
        int count = h.containsKey(number) ? h.get(number) : 0;
        h.put(number, count + 1);
    }

    public boolean find(int value)
    {
        for (Integer key : h.keySet()) {
            int target = value - key;

            if (target == key) {
                return h.get(key) == 2;
            } else if (h.containsKey(target)) {
                return true;
            }
        }

        return false;
    }
}
