package matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two sparse matrices A and B, return the result of AB.
 *
 * You may assume that A's column number is equal to B's row number.
 *
 * Example:
 *
 * A = [
 *   [ 1, 0, 0],
 *   [-1, 0, 3]
 * ]
 *
 * B = [
 *   [ 7, 0, 0 ],
 *   [ 0, 0, 0 ],
 *   [ 0, 0, 1 ]
 * ]
 *
 *
 *      |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
 * AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
 *                   | 0 0 1 |
 *
 * [Difficulty] - Hard
 * [Source]     - {@linkplain https://leetcode.com/problems/sparse-matrix-multiplication/}
 *
 */
public class sparse_matrix_multiplication
{
    public int[][] multiply(int[][] A, int[][] B)
    {
        if (A == null || B == null || A.length == 0 || B.length == 0) {
            return new int[0][0];
        }

        int[][] result = new int[A.length][B[0].length];
        int ma = A.length;
        int na = A[0].length;
        int mb = B.length;
        int nb = B[0].length;

        assert na == mb;

        for (int i = 0; i < ma; i++) {
            for (int k = 0; k < nb; k++) {
                /*
                 * Simulate the horizontal vector of A and vertical vector of B multiplication.
                 */
                for (int j = 0; j < na /* == mb */; j++) {
                    /*
                     * We can optimize this because either A[i][j] or B[j][k] could be 0.
                     */
                    result[i][k] += A[i][j] * B[j][k];
                }
            }
        }

        return result;
    }

    public class Element
    {
        int col;
        int v;

        Element(int v_, int col_) {
            col = col_;
            v = v_;
        }
    }

    public int[][] multiplyOptimized(int[][] A, int[][] B)
    {
        if (A == null || B == null || A.length == 0 || B.length == 0) {
            return new int[0][0];
        }

        int[][] result = new int[A.length][B[0].length];
        int ma = A.length;
        int na = A[0].length;
        int mb = B.length;
        int nb = B[0].length;

        assert na == mb;

        @SuppressWarnings("unchecked")
        List<Element>[] bRowMap = new List[mb];
        for (int i = 0; i < mb; i++) {
            bRowMap[i] = new ArrayList<>();

            for (int j = 0; j < nb; j++) {
                int v = B[i][j];

                if (v == 0) {
                    continue;
                }

                bRowMap[i].add(new Element(v, j));
            }
        }

        for (int i = 0; i < ma; i++) {
            for (int j = 0; j < na /* == mb */; j++) {
                if (A[i][j] == 0) {
                    continue;
                }

                for (Element be : (List<Element>) bRowMap[j]) {
                    result[i][be.col] += A[i][j] * be.v;
                }
            }
        }

        return result;
    }
}
