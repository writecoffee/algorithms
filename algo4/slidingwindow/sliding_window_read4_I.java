/**
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
 *
 * The return value is the actual number of characters read. For example, it
 * returns 3 if there is only 3 characters left in the file.
 *
 * By using the read4 API, implement the function int read(char *buf, int n)
 * that reads n characters from the file.
 *
 * Note: The read function will only be called once for each test case.
 *
 * [Difficulty] - Easy
 * [Source]     - {@linkplain https://leetcode.com/problems/read-n-characters-given-read4/}
 * [Tag]        - $sliding window$
 *
 */
public abstract class sliding_window_read4_I
{
    public abstract int read4(char[] retrieval);

    /**
     * @param buf
     *            Destination buffer
     * @param n
     *            Maximum number of characters to read
     * @return The number of characters read
     */
    public int read(char[] buf, int n)
    {
        int i = 0, numRead = 4;
        char[] t = new char[4];

        while (i < n && numRead == 4) {
            numRead = read4(t);

            System.arraycopy(t, 0, buf, i, Math.min(numRead, n - i));
            i += Math.min(numRead, n - i);
        }

        return i;
    }
}
