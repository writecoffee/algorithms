public class bit_find_unique_duplicate_number {
    /**
     * There are N + 1 elements in the array from 1 to N and there is only
     * one duplicate element in the array.
     * 
     * Let the duplicate number be A, the XOR result of all other N number be B.
     * 
     * XOR result of all N + 1 elements is A ^ A ^ B
     * XOR result of all unique elements is A ^ B
     * 
     * So (A ^ B) ^ (A ^ A ^ B) = A
     * 
     */
    int findDuplicate(int[] array) {
        int n = array.length;
        int result = 0;

        for (int i = 0; i < n; ++i) {
            result ^= array[i];
        }

        for (int i = 1; i < n; ++i) {
            result ^= i;
        }

        return result;
    }
}