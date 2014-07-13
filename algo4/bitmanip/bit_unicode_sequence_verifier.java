/**
 * Given a sequence of uni-code bytes, determine whether it is valid based on
 * the following rules:
 * 
 * 0xxxxxxxx: Serve as a one byte uni-code.
 * 10xxxxxxx: Serve as a continuation.
 * 110xxxxxx: Serve as a 2 bytes uni-code and expect 1 byte of continuation.
 * 1110xxxxx: Serve as a 3 bytes uni-code and expect 2 bytes of continuation.
 * ...
 * 111111111: Serve as a 8 bytes uni-code and expect 7 bytes of continuation.
 *
 * [Difficulty] - Medium
 * [Source]     - google interview
 * 
 */
public class bit_unicode_sequence_verifier {
    public boolean verify(byte[] bytes) {
        int n = bytes.length, flag = 0;

        for (int i = 0; i < n; ++i) {
            int zeroPos = detectZeroPosition(bytes[i]);

            if (flag > 0 && zeroPos != 1) {
                return false;
            } else if (flag == 0 && zeroPos == 1) {
                return false;
            } else if (flag == 0 && zeroPos > 1) {
                flag = zeroPos - 1;
            } else {
                flag--;
            }
        }

        return flag == 0;
    }

    private int detectZeroPosition(byte b) {
        for (int i = 0; i < 8; ++i) {
            if (((1 << (7 - i)) & b) == 0) {
                return i;
            }
        }

        return 8;
    }
}