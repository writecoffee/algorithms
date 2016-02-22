package matrix;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

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
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://leetcode.com/problems/sparse-matrix-multiplication/}
 *
 */
public class sparse_matrix_multiplication
{
    public int[][] multiply(int[][] a, int[][] b)
    {
        int ma = a.length, na = a[0].length;
        int nb = b[0].length;
        int[][] c = new int[ma][nb];

        for (int i = 0; i < ma; i++) {
            for (int k = 0; k < na; k++) {
                if (a[i][k] == 0) {
                    continue;
                }

                for (int j = 0; j < nb; j++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return c;
    }

    public int[][] multiplyUsingHashtable(int[][] a, int[][] b)
    {
        int ma = a.length, na = a[0].length;
        int mb = b.length, nb = b[0].length;
        int[][] c = new int[ma][nb];

        Map<Integer, Map<Integer, Integer>> ha = new HashMap<>();
        Map<Integer, Map<Integer, Integer>> hb = new HashMap<>();

        for (int i = 0; i < ma; i++) {
            for (int j = 0; j < na; j++) {
                Map<Integer, Integer> rowMap = ha.get(i);

                if (a[i][j] != 0 && rowMap == null) {
                    rowMap = new HashMap<>();
                    ha.put(i, rowMap);
                }

                if (a[i][j] != 0) {
                    rowMap.put(j, a[i][j]);
                }
            }
        }

        for (int i = 0; i < mb; i++) {
            for (int j = 0; j < nb; j++) {
                Map<Integer, Integer> rowMap = hb.get(i);

                if (b[i][j] != 0 && rowMap == null) {
                    rowMap = new HashMap<>();
                    ha.put(i, rowMap);
                }

                if (b[i][j] != 0) {
                    rowMap.put(j, b[i][j]);
                }
            }
        }

        for (Entry<Integer, Map<Integer, Integer>> entry : ha.entrySet()) {
            int ia = entry.getKey();

            for (Entry<Integer, Integer> entRow : entry.getValue().entrySet()) {
                int ja = entRow.getKey();
                int vala = entRow.getValue();

                Map<Integer, Integer> bRow = hb.get(ja);

                if (bRow == null) {
                    continue;
                }

                for (Entry<Integer, Integer> entCol : bRow.entrySet()) {
                    int k = entCol.getKey();
                    int valb = entCol.getValue();

                    c[ia][k] += vala * valb;
                }
            }
        }

        return c;
    }
}
