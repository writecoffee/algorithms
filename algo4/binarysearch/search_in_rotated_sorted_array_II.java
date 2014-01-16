public class search_in_rotated_sorted_array_II {    public boolean search(int[] A, int target) {        int n = A.length;
        for (int i = 0; i < n; i++) {            if (A[i] == target) {                return true;            }        }

        return false;    }}