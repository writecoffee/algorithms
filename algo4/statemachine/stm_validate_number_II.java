import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
 *    "2e1.0"    => false
 *    "2e+3"    => true
 *    "2e+3.5"    => false
 *
 * Scientific notation in java:
 *
 * Section 3.10.2 of the JLS talks about floating-point literals in Java.
 * In short, provide the decimal part as if it were scientific notation,
 * but instead of x 10^23 you would write e23:
 *
 * 3.30e23
 *
 * To write one with a negative exponent, you can do that easily also for
 * 6.67 x 10^(-11):
 *
 * 6.67e−11
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
public class stm_validate_number_II
{
    private enum State {
        START,
        INVALID,
        HEADING_SPACE,
        SIGNED,
        INT,
        HEADING_DOT,
        EXP_START,
        TAILING_SPACE,
        FLOAT,
        EXP_END_WITH_INTEGER,
        EXP_END_WITH_HEADING_SIGN
    }

    private enum Token {
        OTHER, SPACE, SIGN, DIGIT, DOT, EXP
    }

    private static class Pair
    {
        State first;
        Token second;

        Pair(State f, Token s) {
            first = f;
            second = s;
        }

        @Override
        public int hashCode()
        {
            return first.ordinal() * 31 + second.ordinal();
        }

        @Override
        public boolean equals(Object o)
        {
            if (o == null || o.getClass() != getClass()) {
                return false;
            }

            Pair op = (Pair) o;
            return op.first == first && op.second == second;
        }
    }

    private static final Map<Pair, State> TRANSITION_MAP = new HashMap<>();
    static {
        TRANSITION_MAP.put(new Pair(State.START, Token.SPACE), State.HEADING_SPACE);
        TRANSITION_MAP.put(new Pair(State.START, Token.SIGN), State.SIGNED);
        TRANSITION_MAP.put(new Pair(State.START, Token.DIGIT), State.INT);
        TRANSITION_MAP.put(new Pair(State.START, Token.DOT), State.HEADING_DOT);

        TRANSITION_MAP.put(new Pair(State.SIGNED, Token.DIGIT), State.INT);
        TRANSITION_MAP.put(new Pair(State.SIGNED, Token.DOT), State.HEADING_DOT);

        TRANSITION_MAP.put(new Pair(State.INT, Token.DIGIT), State.INT);
        TRANSITION_MAP.put(new Pair(State.INT, Token.DOT), State.FLOAT);
        TRANSITION_MAP.put(new Pair(State.INT, Token.EXP), State.EXP_START);

        TRANSITION_MAP.put(new Pair(State.HEADING_DOT, Token.DIGIT), State.FLOAT);

        TRANSITION_MAP.put(new Pair(State.EXP_START, Token.SIGN), State.EXP_END_WITH_HEADING_SIGN);
        TRANSITION_MAP.put(new Pair(State.EXP_START, Token.DIGIT), State.EXP_END_WITH_INTEGER);

        TRANSITION_MAP.put(new Pair(State.EXP_END_WITH_HEADING_SIGN, Token.DIGIT), State.EXP_END_WITH_INTEGER);

        TRANSITION_MAP.put(new Pair(State.FLOAT, Token.DIGIT), State.FLOAT);
        TRANSITION_MAP.put(new Pair(State.FLOAT, Token.EXP), State.EXP_START);

        TRANSITION_MAP.put(new Pair(State.EXP_END_WITH_INTEGER, Token.DIGIT), State.EXP_END_WITH_INTEGER);
    }

    private State transit(State current, Token token)
    {
        Pair p = new Pair(current, token);
        State nextState = TRANSITION_MAP.get(p);

        if (nextState == null) {
            return State.INVALID;
        }

        return nextState;
    }

    private static final Set<State> FINITE_STATE = new HashSet<>();
    static {
        FINITE_STATE.add(State.FLOAT);
        FINITE_STATE.add(State.INT);
        FINITE_STATE.add(State.EXP_END_WITH_INTEGER);
    }

    public boolean isNumber(String s)
    {
        State last = State.START;
        int n = s.length();

        int start = 0;
        for (; start < n && s.charAt(start) == ' '; start++) {
        }

        int end = n - 1;
        for (; end >= start && s.charAt(end) == ' '; end--) {
        }

        s = s.substring(start, end + 1);

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            Token token = Token.OTHER;

            if (c == ' ') {
                token = Token.SPACE;
            } else if (Character.isDigit(c)) {
                token = Token.DIGIT;
            } else if (c == '+' || c == '-') {
                token = Token.SIGN;
            } else if (c == 'e') {
                token = Token.EXP;
            } else if (c == '.') {
                token = Token.DOT;
            }

            last = transit(last, token);
            if (last == State.INVALID) {
                return false;
            }
        }

        return FINITE_STATE.contains(last);
    }
}
