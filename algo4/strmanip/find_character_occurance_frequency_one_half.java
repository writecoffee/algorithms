/**
 * Given a string, design an algorithm in O(n) running time to find the character that 
 * appears more than half of the time in the string. If the character does not exist, 
 * output null.
 * 
 * Input: abadacababaaaa
 * Output: a
 * 
 * Input: abcdeabbad
 * Output: null
 * 
 * [Difficulty] - Easy
 * [Source]     - mercurial system quiz
 *
 */
public class find_character_occurance_frequency_one_half {
    public static Character findAppearHalfOfTime(String s) {
        if (s == null) {
            return null;
        }

        int n = s.length(), half = n / 2;
        int[] records = new int[256];

        for (int i = 0; i < n; ++i) {
            if (++records[s.charAt(i)] > half) {
                return s.charAt(i);
            }
        }

        return null;
    }

    public static void main(String[] args) {
        assert findAppearHalfOfTime("abadacababaaaa") == 'a';
        assert findAppearHalfOfTime("abcdeabbad") == null;
        assert findAppearHalfOfTime("aba") == 'a';
        assert findAppearHalfOfTime("a*****") == '*';
        assert findAppearHalfOfTime("aa") == null;
        assert findAppearHalfOfTime("") == null;
        assert findAppearHalfOfTime(null) == null;
    }
}