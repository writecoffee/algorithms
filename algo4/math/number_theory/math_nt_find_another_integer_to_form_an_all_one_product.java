package number_theory;

public class math_nt_find_another_integer_to_form_an_all_one_product
{
    public int findMinAllOne(int a)
    {
        int[] m = new int[] { 0, 1, 0, 1, 0, 0, 0, 1, 0, 1 };
        if (m[a % 10] == 0) {
            return -1;
        } else if (a == 1) {
            return 1;
        }

        int count = 1;
        for (int i = 1; i > 0; i %= a) {
            i = i * 10 + 1;
            count++;
        }

        return count;
    }
}