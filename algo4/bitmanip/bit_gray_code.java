import java.util.ArrayList;

public class bit_gray_code {
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        result.add(0);
        for (int i = 0; i < n; i++) {
            int flipMask = 1 << i;

            for (int j = result.size() - 1; j >= 0; j--) {
                result.add(result.get(j) | flipMask);
            }
        }

        return result;
    }
}