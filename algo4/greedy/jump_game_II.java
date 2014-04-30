public class jump_game_II {
    public int jump(int[] array) {
        int n = array.length;
        int i = n - 1;
        int result = 0;

        while (i > 0) {
            int maxJmp = -1;

            for (int j = i - 1; j >= 0; --j) {
                if (array[j] >= i - j) {
                    maxJmp = i - j;
                }
            }

            if (maxJmp == -1) {
                return -1;
            } else {
                i -= maxJmp;
                result++;
            }
        }

        return result;
    }
}
