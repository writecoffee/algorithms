/**
 * There are N + 1 positive numbers in the array ranging from 1 to N and there is only
 * one duplicate element in the array. Find this element out.
 * 
 * We know we can sum all numbers in the array then minus (n + 1) * n / 2. But can we
 * use bit operation to accelerate this process?
 * 
 * [Difficulty] - Hard
 * [Source]     - unknown
 * 
 */
public class bit_find_the_only_one_duplicate_number {
    /**
     * 
     * Let the duplicate number be A, the XOR result of all other N number be B.
     * 
     * XOR result of all N + 1 elements is A ^ A ^ B.
     * XOR result of all unique elements is A ^ B.
     * 
     * So (A ^ B) ^ (A ^ A ^ B) = A.
     * 
     */
    public int findDuplicate(int[] array) {
        int n = array.length, x = array[0];

        for (int i = 1; i < n; ++i) {
            x ^= (array[i] ^ i);
        }

        return x;
    }
}