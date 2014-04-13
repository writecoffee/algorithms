public class permutation_sequence {
    public String getPermutation(int n, int k) {
        StringBuilder result = new StringBuilder(), t = new StringBuilder();

        int f = 1;
        for (int i = 1; i < n + 1; i++) {
            t.append(i);
            f *= i;
        }

        k--;
        for (int numCnt = n; numCnt > 0; --numCnt, f /= numCnt, k %= f) {
            int slotCnt = f / numCnt;
            int numIndex = k / slotCnt;
            result.append(t.charAt(numIndex));
            t.delete(numIndex, numIndex + 1);
        }

        return result.toString();
    }
}