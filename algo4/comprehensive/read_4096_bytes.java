/**
 * Given API:
 * 
 * int Read4096(char* buf);
 * 
 * It reads data from a file and records the position so that the next time when it is called it
 * read the next 4k chars (or the rest of the file, whichever is smaller) from the file.
 * 
 * The return is the number of chars read.
 * 
 * Todo:
 * 
 * Use above API to Implement API "int Read(char* buf, int n)" which reads any number of chars
 * from the file.
 * 
 */
public class read_4096_bytes {
    public int read4096(char[] buf) {
        return 4096;
    }

    public int read(int n, char[] buf) {
        int totalRead = 0;

        for (int i = 0; i < n / 4096; ++i) {
            char[] tbuf = new char[4096];
            int tRead = read4096(tbuf);

            totalRead += copyTo(buf, totalRead, tbuf, tRead);

            if (tRead < 4096) {
                return totalRead;
            }
        }

        char[] tbuf = new char[4096];
        int tRead = read4096(tbuf);
        totalRead += copyTo(buf, totalRead, tbuf, Math.min(tRead, n % 4096));

        return totalRead;
    }

    private int copyTo(char[] buf, int start, char[] tbuf, int num_read) {
        for (int i = 0; i < num_read; ++i) {
            buf[start + i] = tbuf[i];
        }

        return num_read;
    }
}