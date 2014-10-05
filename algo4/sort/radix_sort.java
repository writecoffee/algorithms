public class radix_sort
{
    public void sort(int[] array)
    {
        int n = array.length;

        for (int i = 0; i < 32; i++) {
            int[] counter = new int[2];

            for (int number : array) {
                counter[(number >>> i) & 1]++;
            }

            counter[1] += counter[0];

            int[] aux = new int[n];
            for (int j = n - 1; j >= 0; j--) {
                int number = array[j];
                aux[--counter[(number >>> i) & 1]] = number;
            }

            array = aux;
        }
    }
}
