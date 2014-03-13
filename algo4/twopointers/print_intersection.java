import java.util.ArrayList;

public class print_intersection {
    static ArrayList<Integer> intesect(int[] A, int[] B) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int m = A.length;
        int n = B.length;
        int i = 0;
        int j = 0;

        while (i < m && j < n) {
            if (A[i] == A[j]) {
                while (i < m && A[i] == A[j]) {
                    i++;
                }

                result.add(A[j++]);
            } else if (A[i] > A[j]) {
                j++;
            } else {
                i++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        intesect(new int[] { 1, 2, 3, 3, 4 }, new int[] { 1, 3, 4, 5 });
        intesect(new int[] { 2, 3, 3, 4, 5 }, new int[] { 1, 3, 3, 4, 4, 5 });
    }
}