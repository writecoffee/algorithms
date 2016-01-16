package window;
import java.util.LinkedList;
import java.util.Queue;

/**
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
 *
 * The return value is the actual number of characters read. For example, it
 * returns 3 if there is only 3 characters left in the file.
 *
 * By using the read4 API, implement the function int read(char *buf, int n)
 * that reads n characters from the file.
 *
 * Note: The read function may be called multiple times.
 *
 * [Difficulty] - Medium
 * [Source]     - facebook interview, {@linkplain https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/}
 * [Tag]        - $sliding window$
 *
 */
public abstract class tp_window_read4_II
{
    public abstract int read4(char[] retrieval);

    public class ReaderWithQueue
    {
        Queue<Character> q = new LinkedList<Character>();

        /**
         * @param buf
         *            Destination buffer
         * @param n
         *            Maximum number of characters to read
         * @return The number of characters read
         */
        public int read(char[] buf, int n)
        {
            int i = 0, numRead = 4, numExtra = 0;

            while (!q.isEmpty() && i < n) {
                buf[i] = q.poll();
                i++;
            }

            if (i == n) {
                return i;
            }

            char[] t = new char[4];
            while (i < n && numRead == 4) {
                numRead = read4(t);

                System.arraycopy(t, 0, buf, i, Math.min(numRead, n - i));
                numExtra = Math.max(numRead - (n - i), 0);
                i += Math.min(numRead, n - i);
            }

            for (; numExtra > 0; numExtra--) {
                q.add(t[numRead - numExtra]);
            }

            return i;
        }
    }

    public class ReaderWithArray
    {
        char[] window = new char[4];
        int i = 0, j = 0;

        /**
         * @param buf
         *            Destination buffer
         * @param n
         *            Maximum number of characters to read
         * @return The number of characters read
         */
        public int read(char[] buf, int n)
        {
            int numRead = 4, numExtra = 0, start = 0, carry = Math.min(j - i, n);

            if (carry > 0) {
                System.arraycopy(window, i, buf, 0, carry);
                i += carry;
                start += carry;
            }

            if (i == j) {
                i = j = 0;
            }

            char[] t = new char[4];
            while (start < n && numRead == 4) {
                numRead = read4(t);

                System.arraycopy(t, 0, buf, start, Math.min(numRead, n - start));
                numExtra = Math.max(numRead - (n - start), 0);
                start += Math.min(numRead, n - start);
            }

            if (numExtra > 0) {
                System.arraycopy(t, numRead - numExtra, window, 0, numExtra);
                j += numExtra;
            }

            return start;
        }
    }
}
