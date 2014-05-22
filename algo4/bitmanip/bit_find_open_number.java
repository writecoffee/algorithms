public class bit_find_open_number {
    public int findOpenNumber(int[] numbers0, int upperBound) {
        int n = numbers0.length;
        byte[] bitfield = new byte[(int) (upperBound / 8)];

        for (int i = 0; i < n; ++i) {
            bitfield[numbers0[i] / 8] |= 1 << (numbers0[i] % 8);
        }

        for (int i = 0; i < bitfield.length; ++i) {
            for (int j = 0; j < 8; ++j) {
                if ((bitfield[i] & (1 << j)) == 0) {
                    return i * 8 + j;
                }
            }
        }

        return -1;
    }
}