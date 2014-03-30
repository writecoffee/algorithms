public class find_another_integer_to_form_an_all_one_product {
    static int findMinAllOne(int a) {
        int[] m = new int[] { 0, 1, 0, 1, 0, 0, 0, 1, 0, 1 };
        if (m[a % 10] == 0) {
            return -1;
        }

        int count = 1;
        for (int i = 1; i > 0; i %= a) {
            i = i * 10 + 1;
            count++;
        }

        return a == 1 ? 1 : count;
    }

    public static void main(String[] args) {
        assert findMinAllOne(3) == 3;
        assert findMinAllOne(33) == 6;
        assert findMinAllOne(24) == -1;
        assert findMinAllOne(1) == 1;
    }
}