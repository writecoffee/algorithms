/**
 * Given input of arithmetic expression with ONLY digit and +, -, * and /, parse the expression and 
 * evaluate it. You may assume the input is legal but there could be space in the expression.
 *
 * Input: 5.6 / 0.7 * 2 – 3.5
 * Output: 12.5
 *
 * Input: -1.3 + 5.1 / 3 – 0.8
 * Output: -0.4
 * 
 * [Difficulty] - Medium
 * [Source]     - mercurial system quiz
 *
 */
public class evaluate_simple_expression_II {
    private static double evaluate(String[] nums, int m, int i, String[] ops, int n, int j, double coeff) {
        double operand = 0f;

        if (j < n && ops[j].isEmpty()) {
            return evaluate(nums, m, i, ops, n, j + 1, coeff);
        } else if (!nums[i].isEmpty() && j > 0 && ops[j - 1].equals("/")) {
            operand = 1 / Double.parseDouble(nums[i]);
        } else if (!nums[i].isEmpty()) {
            operand = Double.parseDouble(nums[i]);
        }

        if (i == m - 1) {
            return coeff * operand;
        } else if (ops[j].equals("+")) {
            return coeff * operand + evaluate(nums, m, i + 1, ops, n, j + 1, 1);
        } else if (ops[j].equals("-")) {
            return coeff * operand + evaluate(nums, m, i + 1, ops, n, j + 1, -1);
        } else {
            return evaluate(nums, m, i + 1, ops, n, j + 1, coeff * operand);
        }
    }

    public static String evaluate(String expr) {
        expr = expr.replaceAll("\\s+", "");
        String[] nums = expr.split("[/*+-]");
        String[] ops = expr.split("(\\w)+(\\.(\\w)*)?");

        return String.format("%.1f", evaluate(nums, nums.length, 0, ops, ops.length, 0, 1));
    }

    public static void main(String[] args) {
        assert evaluate("-1.3 +5.1 / 3 - 0.8").equals("-0.4");
        assert evaluate("5.6 / 0.7 * 2 - 3.5").equals("12.5");
        assert evaluate("3.5").equals("3.5");
        assert evaluate("-0").equals("0.0");
        assert evaluate("-0.").equals("0.0");
        assert evaluate("0.").equals("0.0");
    }
}