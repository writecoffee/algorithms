public class jump_game_II {

    public static int jump(int[] A) {
        int steps = 0;
        int max = 0;
        int next = 0;

        for (int i = 0; i < A.length - 1 && next < A.length - 1; ++i) {
            max = Math.max(max, i + A[i]);

            if (i == next) {
                if (max == next) {
                    return -1;
                }

                next = max;
                ++steps;
            }
        }

        return steps;
    }

    public static void main(String[] args) {
        jump(new int[] { 2, 3, 1, 1, 4 });
    }
}