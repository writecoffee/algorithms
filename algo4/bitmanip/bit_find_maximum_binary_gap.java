/**
 * Get maximum binary Gap.
 * 
 * For example, 9's binary form is 1001, the gap is 2.
 * 
 * [Difficulty] - Medium
 * [Source]     - twitter quiz
 * 
 */
public class bit_find_maximum_binary_gap {
    public int findGap(int number) {
        int gMax = 0;

        for (int i = 0, j = -1; i < 32; ++i) {
            int bit = number & (1 << i);

            if (bit != 0 && j >= 0) {
                gMax = Math.max(gMax, i - j);
                j = -1;
            } else if (bit == 0 && j == -1) {
                j = i;
            }
        }

        return gMax;
    }
}