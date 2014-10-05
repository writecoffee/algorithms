import java.util.ArrayList;
import java.util.List;
import java.util.function.IntUnaryOperator;

/**
 * Given a string that contains only digits 0-9 and a target value, return all
 * possibilities to add binary operators (not unary) +, -, or * between the
 * digits so they evaluate to the target value.
 *
 * Examples:
 *
 * "123", 6 -> ["1+2+3", "1*2*3"]
 *
 * "232", 8 -> ["2*3+2", "2+3*2"]
 *
 * "105", 5 -> ["1*0+5","10-5"]
 *
 * "00", 0 -> ["0+0", "0-0", "0*0"]
 *
 * "3456237490", * 9191 -> []
 *
 * [Difficulty] - Hard
 * [Source]     - {@linkplain https://leetcode.com/problems/expression-add-operators/}
 * [Tag]        - $dfs$, $divide_conquer$
 *
 */
public class divconq_expression_add_operators
{
    public List<String> addOperators(String num, int target)
    {
        List<String> result = new ArrayList<>();

        if (num.length() == 0) {
            return result;
        }

        int[] nums = num.chars().map(new IntUnaryOperator() {
            @Override
            public int applyAsInt(int operand)
            {
                return operand - '0';
            }
        }).toArray();

        for (int i = 0; i < nums.length; i++) {
            long currentDigit = nums[0];

            if (currentDigit == 0 && i > 0) {
                break;
            }

            for (int j = 1; j <= i; j++) {
                currentDigit = currentDigit * 10 + nums[j];
            }

            divideConquer(nums, i, target, result, currentDigit, currentDigit, new StringBuilder().append(currentDigit));
        }

        return result;
    }

    private void divideConquer(int[] nums, int i, int target, List<String> result, long leftOperand, long lastDigit, StringBuilder leftProcess)
    {
        if (i == nums.length - 1 && leftOperand == target) {
            result.add(leftProcess.toString());
            return;
        } else if (i == nums.length - 1) {
            return;
        }

        for (int j = i + 1; j <= nums.length - 1; j++) {
            long currentDigit = nums[i + 1];

            if (currentDigit == 0 && j > i + 1) {
                break;
            }

            for (int k = i + 2; k <= j; k++) {
                currentDigit = currentDigit * 10 + nums[k];
            }

            divideConquer(nums, j, target, result, leftOperand + currentDigit, currentDigit, leftProcess.append("+" + currentDigit));
            leftProcess.delete(leftProcess.length() - (j - i)  - 1, leftProcess.length());

            divideConquer(nums, j, target, result, leftOperand - currentDigit, -currentDigit, leftProcess.append("-" + currentDigit));
            leftProcess.delete(leftProcess.length() - (j - i)  - 1, leftProcess.length());

            divideConquer(nums, j, target, result, leftOperand - lastDigit + (lastDigit * currentDigit), lastDigit * currentDigit, leftProcess.append("*" + currentDigit));
            leftProcess.delete(leftProcess.length() - (j - i)  - 1, leftProcess.length());
        }
    }
}
