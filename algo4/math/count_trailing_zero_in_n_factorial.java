import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Count the trailing zero in n!.
 * 
 * [Difficulty] - Medium
 * [Source]     - facebook interview, {@linkplain http://acm.zju.edu.cn/onlinejudge/showProblem.do?problemCode=2022}
 *
 */
public class count_trailing_zero_in_n_factorial {
    /**
     * The key observation here is that how many 10 could be formed from the number
     * 1 to n. 10 could be multiplied by 2 and 5, also because there will be an even
     * number every 2 numbers, the task becomes counting how many number of 5 in all
     * factors of n!.
     * 
     */
    public static int countTrailingZero(int n) {
        int count = 0, divisor = 5;

        while (n / divisor > 0) {
            for (int i = 1; i <= n; ++i) {
                if (i % divisor == 0) {
                    count++;
                }
            }

            divisor *= 5;
        }

        return count;
    }

    public static int countTrailingZeroImproved(int n) {
        int count = 0;

        for (int divisor = 5; divisor <= n; divisor *= 5) {
            count += n / divisor;
        }

        return count;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int n = Integer.parseInt(in.readLine());

        for (int i = 0; i < n; ++i) {
            out.println(countTrailingZeroImproved(Integer.parseInt(in.readLine())));
        }

        in.close();
        out.close();
    }
}