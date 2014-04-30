public class jump_game {
    public boolean canJump(int[] array) {
        int n = array.length;

        int i = 0;
        while (i < n) {
            int jmp = array[i];
            if (jmp == 0) {
                break;
            }

            i += jmp;
        }

        return i >= n - 1;
    }
}
