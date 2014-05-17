public class tp_remove_element {
    public int removeElement(int[] array, int elem) {
        int n = array.length;
        int j = 0;

        for (int i = 0; i < n; ++i) {
            if (array[i] != elem) {
                array[j++] = array[i];
            }
        }

        return j;
    }
}