import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Count the biggest threat over all the queens represented by input
 *
 * N (number of row/column)
 * row-0: i, A[0][i] occupied by a queen
 * row-1: j, A[1][j] occupied by a queen
 * ...
 *
 * [Source]     - OA
 * [Difficulty] - Medium
 *
 */
public class n_queens_count_threats
{
    static int maxThreats(int[] a)
    {
        int n = a.length;
        int[] result = new int[n];
        int gMax = 0;

        int bytesNeeded = n / 8;
        if (n % 8 != 0) {
            bytesNeeded += 1;
        }

        BigInteger leftDiagThreat = new BigInteger(new byte[bytesNeeded]);
        BigInteger rightDiagThreat = new BigInteger(new byte[bytesNeeded]);
        BigInteger verticalThreat = new BigInteger(new byte[bytesNeeded]);

        for (int i = 0; i < n; i++) {
            BigInteger rowMask = new BigInteger(new byte[bytesNeeded]);
            rowMask = rowMask.setBit(a[i]);

            if (!leftDiagThreat.and(rowMask).equals(BigInteger.ZERO)) {
                result[i]++;
            }

            if (!rightDiagThreat.and(rowMask).equals(BigInteger.ZERO)) {
                result[i]++;
            }

            if (!verticalThreat.and(rowMask).equals(BigInteger.ZERO)) {
                result[i]++;
            }

            verticalThreat = verticalThreat.or(rowMask);
            leftDiagThreat = leftDiagThreat.or(rowMask).shiftLeft(1);
            rightDiagThreat = rightDiagThreat.or(rowMask).shiftRight(1);
        }

        /*
         * Clean up bits.
         */
        leftDiagThreat = new BigInteger(new byte[bytesNeeded]);
        rightDiagThreat = new BigInteger(new byte[bytesNeeded]);
        verticalThreat = new BigInteger(new byte[bytesNeeded]);

        for (int i = n - 1; i >= 0; i--) {
            BigInteger rowMask = new BigInteger(new byte[bytesNeeded]);
            rowMask = rowMask.setBit(a[i]);

            if (!leftDiagThreat.and(rowMask).equals(BigInteger.ZERO)) {
                result[i]++;
            }

            if (!rightDiagThreat.and(rowMask).equals(BigInteger.ZERO)) {
                result[i]++;
            }

            if (!verticalThreat.and(rowMask).equals(BigInteger.ZERO)) {
                result[i]++;
            }

            verticalThreat = verticalThreat.or(rowMask);
            leftDiagThreat = leftDiagThreat.or(rowMask).shiftLeft(1);
            rightDiagThreat = rightDiagThreat.or(rowMask).shiftRight(1);
            gMax = Math.max(gMax, result[i]);
        }

        return gMax;
    }

    public static void main(String[] args) throws IOException
    {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        int res;

        int _a_size = 0;
        _a_size = Integer.parseInt(in.nextLine().trim());
        int[] _a = new int[_a_size];
        int _a_item;
        for (int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(in.nextLine().trim());
            _a[_a_i] = _a_item;
        }

        res = maxThreats(_a);
        System.out.println(res);
        bw.write(String.valueOf(res));
        bw.newLine();

        in.close();
        bw.close();
    }
}
