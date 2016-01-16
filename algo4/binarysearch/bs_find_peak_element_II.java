import java.util.ArrayList;
import java.util.List;

/**
 * There is an integer matrix which has the following features:
 *
 *  -- The numbers in adjacent positions are different.
 *  -- The matrix has n rows and m columns.
 *  -- For all i < m, A[0][i] < A[1][i] && A[n - 2][i] > A[n - 1][i].
 *  -- For all j < n, A[j][0] < A[j][1] && A[j][m - 2] > A[j][m - 1].
 *
 * We define a position P is a peek if:
 *
 * A[j][i] > A[j+1][i] && A[j][i] > A[j-1][i] && A[j][i] > A[j][i+1] && A[j][i] > A[j][i-1].
 * 
 * Find a peak element in this matrix. Return the index of the peak.
 *
 * Have you met this question in a real interview? Yes
 *
 * Example
 *
 * Given a matrix:
 *
 * [
 *   [1 ,2 ,3 ,6 ,5],
 *   [16,41,23,22,6],
 *   [15,17,24,21,7],
 *   [14,18,19,20,10],
 *   [13,14,11,10,9]
 * ]
 *
 * return index of 41 (which is [1,1]) or index of 24 (which is [2,2])
 *
 * Note
 *
 * The matrix may contains multiple peeks, find any of them.
 *
 * Challenge
 *
 * Solve it in O(n+m) time.
 *
 * If you come up with an algorithm that you thought it is O(n log m) or O(m log n), 
 * can you prove it is actually O(n+m) or propose a similar but O(n+m) algorithm?
 *
 * [Difficulty] - Hard
 * [Source]     - {@linkplain http://www.lintcode.com/en/problem/find-peak-element-ii/}
 *
 */
public class bs_find_peak_element_II
{
    public List<Integer> findPeakII(int[][] A)
    {
        List<Integer> result = new ArrayList<>();

        for (int iStart = 1, iEnd = A.length - 1, jStart = 1, jEnd = A[0].length - 1; iStart <= iEnd && jStart <= jEnd;) {
            int mid = iStart + (iEnd - iStart) >> 1;
            int rowMaxIndex = findColumn(A[mid], jStart, jEnd);
            int rowMax = A[mid][rowMaxIndex];

            if (rowMax > A[mid - 1][rowMaxIndex] && rowMax > A[mid + 1][rowMaxIndex]) {
                result.add(mid);
                result.add(rowMaxIndex);
                break;
            } else if (rowMax < A[mid - 1][rowMaxIndex]) {
                iEnd = mid - 1;
            } else {
                iStart = mid + 1;
            }

            int colMaxIndex = findRow(A, iStart, iEnd, rowMaxIndex);
            int colMax = A[colMaxIndex][rowMaxIndex];

            if (colMax > A[colMaxIndex][rowMaxIndex - 1] && colMax > A[colMaxIndex][rowMaxIndex + 1]) {
                result.add(colMaxIndex);
                result.add(rowMaxIndex);
                break;
            } else if (colMax < A[colMaxIndex][rowMaxIndex - 1]) {
                jEnd = rowMaxIndex - 1;
            } else {
                jStart = rowMaxIndex + 1;
            }
        }

        return result;
    }

    private int findColumn(int[] row, int jStart, int jEnd)
    {
        int result = jStart;

        for (int k = jStart + 1; k <= jEnd; k++) {
            if (row[k] >= row[result]) {
                result = k;
            }
        }

        return result;
    }

    private int findRow(int[][] matrix, int iStart, int iEnd, int column)
    {
        int result = iStart;

        for (int k = iStart + 1; k <= iEnd; k++) {
            if (matrix[k][column] >= matrix[result][column]) {
                result = k;
            }
        }

        return result;
    }
}
