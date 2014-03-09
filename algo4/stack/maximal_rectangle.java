import java.util.Stack;

public class maximal_rectangle {
    public static int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int[] heights = new int[n + 1];
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                heights[j] = (matrix[i][j] == '0') ? 0 : heights[j] + 1;
            }

            result = Math.max(result, largestRectangleArea(heights));
        }

        return result;
    }

    private static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;
        int n = heights.length;

        for (int i = 0; i < n; i++) {
            int width = 0;

            while (!stack.isEmpty() && stack.peek() > heights[i]) {
                width++;
                result = Math.max(result, width * stack.pop());
            }

            /**
             * Cut down the previous heights.
             */
            while (width-- >= 0) {
                stack.push(heights[i]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(maximalRectangle(new char[][] {
            "01101".toCharArray(),
            "11010".toCharArray(),
            "01110".toCharArray(),
            "11110".toCharArray(),
            "11111".toCharArray(),
            "00000".toCharArray()
        }));
    }
}