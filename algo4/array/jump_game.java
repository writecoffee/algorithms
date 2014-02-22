public class jump_game {

    public static boolean canJump(int[] A) {
        int next = A.length - 1;

        for (int i = A.length - 2; i >= 0; --i) {
            if (A[i] >= (next - i)) {
                next = i;
            }
        }

        return (next == 0);
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[] { 2, 3, 1, 1, 4 }));
        System.out.println(canJump(new int[] { 3, 2, 1, 0, 4 }));
    }
}