public class bit_single_number_II {
    int singleNumber(int A[]) {
        int result = 0;
        int n = A.length;

        for (int i = 0; i < 32; ++i) {
            int count = 0;
            int bit = 1 << i;

            for (int j = 0; j < n; ++j) {
                if ((A[j] & bit) != 0) {
                    count++;
                }
            }

            if (count % 3 != 0) {
                result |= bit;
            }
        }

        return result;
    }
}