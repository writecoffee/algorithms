package probe;

/**
 * You are playing the following Flip Game with your friend: Given a string that
 * contains only these two characters: + and -, you and your friend take turns
 * to flip two consecutive "++" into "--". The game ends when a person can no
 * longer make a move and therefore the other person will be the winner.
 *
 * Write a function to determine if the starting player can guarantee a win.
 *
 * For example, given s = "++++", return true. The starting player can guarantee
 * a win by flipping the middle "++" to become "+--+".
 *
 * Follow up:
 *
 * Derive your algorithm's runtime complexity.
 *
 * [Source]     - {@linkplain https://leetcode.com/problems/flip-game-ii/}
 * [Difficulty] - Medium
 *
 */
public class dfs_flip_game_II
{
    public boolean canWin(String s)
    {
        if (s == null) {
            return false;
        }

        return canWin(s.toCharArray());
    }

    private boolean canWin(char[] strChars)
    {
        for (int i = 0; i < strChars.length - 1; i++) {
            if (strChars[i] == '+' && strChars[i + 1] == '+') {
                strChars[i] = strChars[i + 1] = '-';
                boolean win = !canWin(strChars);
                strChars[i] = strChars[i + 1] = '+';

                if (win) {
                    return true;
                }
            }
        }

        return false;
    }
}
