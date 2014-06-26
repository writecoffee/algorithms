/**
 * Given a target number, and we start from 1, we could either multiple current
 * number by 2 or plus one. Find the minimum jump from 1 to n.
 * 
 * For example:
 * 
 * n = 17,
 * 
 * The minimum number of jump is 6, which is [1, 2, 4, 8, 16, 17].
 * 
 * [Difficulty] - Easy
 * [Source]     - twitter quiz
 *
 */
public class jump_game_III {
    public int solution(int n) {
        int count = 0;

        while (n > 0) {
            if ((n & 0x1) == 0) {
                n = n / 2;
            } else {
                n = n - 1;
            }

            count++;
        }

        return count;
    }
}