/**
 * Validate if a given string is numeric.
 * 
 * Some examples:
 * 
 *    "0"       => true
 *    " 0.1 "   => true
 *    "abc"     => false
 *    "1 a"     => false
 *    "2e10"    => true
 * 
 * Note: It is intended for the problem statement to be ambiguous.
 * You should gather all requirements up front before implementing one.
 * 
 * Using e is only a shorthand to simplify the writing of a number, and
 * can be followed either by a (signed) float number or integer. It does
 * not involve any (mathematical) computation, only shifting the decimal
 * mark.
 * 
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/valid-number/}
 *
 */
public class validate_number {
    private enum State {
        INVALID, HEADING_SPACE, SIGNED, INT, HEADING_DOT, EXP_START, TAILING_SPACE, FLOAT, EXP_END_WITH_INTEGER
    }

    private static State[] v = State.values();

    private enum Token {
        OTHER, SPACE, SIGN, DIGIT, DOT, EXP
    }

    private static State[][] transition = new State[][] {
     //   0     1     2     3     4     5
        { v[0], v[1], v[2], v[3], v[4], v[0] }, // 0: INVALID
        { v[0], v[1], v[2], v[3], v[4], v[0] }, // 1: HEADING_SPACE
        { v[0], v[0], v[0], v[3], v[4], v[0] }, // 2: SIGNED
        { v[0], v[6], v[0], v[3], v[7], v[5] }, // 3: INT
        { v[0], v[0], v[0], v[7], v[0], v[0] }, // 4: HEADING_DOT
        { v[0], v[0], v[2], v[8], v[0], v[0] }, // 5: EXP_START
        { v[0], v[6], v[0], v[0], v[0], v[0] }, // 6: TAILING_SPACE
        { v[0], v[6], v[0], v[7], v[0], v[5] }, // 7: FLOAT
        { v[0], v[6], v[0], v[8], v[0], v[0] }  // 8: EXP_END_WITH_INTEGER
    };

    private static boolean[] finiteState = new boolean[] {
        false, false, false, true, false, false, true, true, true 
    };

    public boolean isNumber(String s) {
        State last = State.INVALID;
        int n = s.length();

        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            Token state = Token.OTHER;

            if (c == ' ') {
                state = Token.SPACE;
            } else if (Character.isDigit(c)) {
                state = Token.DIGIT;
            } else if (c == '+' || c == '-') {
                state = Token.SIGN;
            } else if (c == 'e') {
                state = Token.EXP;
            } else if (c == '.') {
                state = Token.DOT;
            }

            last = transition[last.ordinal()][state.ordinal()];
            if (last == State.INVALID) {
                return false;
            }
        }

        return finiteState[last.ordinal()];
    }
}