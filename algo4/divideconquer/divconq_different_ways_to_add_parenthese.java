import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a string of numbers and operators, return all possible results from computing
 * all the different possible ways to group numbers and operators.
 *
 * The valid operators are +, - and *.
 *
 * Example 1
 *
 * Input: "2-1-1".
 *
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 *
 * Output: [0, 2]
 *
 * Example 2
 *
 * Input: "2*3-4*5"
 *
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 *
 * Output: [-34, -14, -10, -10, 10]
 *
 * [Source]     - {@linkplain https://leetcode.com/problems/different-ways-to-add-parentheses/}
 * [Difficulty] - Medium
 *
 */
public class divconq_different_ways_to_add_parenthese
{
    public List<Integer> diffWaysToCompute(String input)
    {
        List<Integer> numbers = new ArrayList<>();
        List<Character> ops = new ArrayList<>();
        int n = input.length();

        for (int i = 0; i < n; ++i) {
            char c = input.charAt(i);

            if (Character.isDigit(c)) {
                int number = c - '0';

                while (Character.isDigit(c) && i + 1 < n && Character.isDigit(input.charAt(i + 1))) {
                    number = 10 * number + (input.charAt(i + 1) - '0');
                    i++;
                }

                numbers.add(number);
            } else {
                ops.add(c);
            }
        }

        return divConq(numbers.toArray(), ops.toArray(), 0, numbers.size());
    }

    private List<Integer> divConq(Object[] numbers, Object[] ops, int start, int end)
    {
        if (end - start == 1) {
            return Arrays.asList((int) numbers[start]);
        }

        List<Integer> result = new ArrayList<>();

        for (int i = start + 1; i < end; ++i) {
            List<Integer> left = divConq(numbers, ops, start, i),
                          right = divConq(numbers, ops, i, end);

            for (int j = 0; j < left.size(); ++j) {
                for (int k = 0; k < right.size(); ++k) {
                    result.add(operatesAt((Integer) left.get(j), (Integer) right.get(k), (Character) ops[i - 1]));
                }
            }
        }

        return result;
    }

    private Integer operatesAt(Integer lOperand, Integer rOperand, Character op)
    {
        switch (op) {
        case '+':
            return lOperand + rOperand;
        case '-':
            return lOperand - rOperand;
        case '*':
            return lOperand * rOperand;
        }

        return null;
    }
}
