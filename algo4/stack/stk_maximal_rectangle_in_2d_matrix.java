import java.util.Stack;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing
 * all ones and return its area.
 * 
 * {@linkplain https://oj.leetcode.com/problems/maximal-rectangle/}
 * 
 */
public class stk_maximal_rectangle_in_2d_matrix {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length, n = matrix[0].length;
        int[] heights = new int[n + 1];
        int gMax = 0;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                heights[j] = matrix[i][j] == '1' ? heights[j] + 1 : 0;
            }

            gMax = Math.max(gMax, calculate(heights));
        }

        return gMax;
    }

    private int calculate(int[] heights) {
        Stack<Integer> stk = new Stack<Integer>();
        int lMax = 0, n = heights.length, i = 0;

        while (i < n) {
            if (stk.isEmpty() || heights[stk.peek()] < heights[i]) {
                stk.push(i++);
            } else {
                int h = heights[stk.pop()];
                int w = stk.isEmpty() ? i : i - stk.peek() - 1;

                lMax = Math.max(lMax, h * w);
            }
        }

        return lMax;
    }
}
