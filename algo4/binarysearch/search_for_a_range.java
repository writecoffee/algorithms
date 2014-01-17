public class search_for_a_range {

    public static int[] searchRange(int[] A, int target) {
        int[] result = new int[] { -1, -1 };

        int lower = 0;
        int upper = A.length;

        while (lower < upper) {
            int mid = (lower + upper) / 2;
            if (A[mid] < target) {
                lower = mid + 1;
            } else {
                upper = mid;
            }
        }

        if (lower < 0 || lower > A.length - 1) {
            return result;
        }

        if (lower == upper && A[lower] != target) {
            return result;
        }

        result[0] = lower;

        upper = A.length;
        while (lower < upper) {
            int mid = (lower + upper) / 2;
            if (A[mid] <= target) {
                lower = mid + 1;
            } else {
                upper = mid;
            }
        }

        result[1] = upper - 1;
        return result;
    }

    static int[] result = searchRange(new int[] { 1, 1, 2, 3, 4, 5 }, 1);
    static int[] result2 = searchRange(new int[] { 1 }, 0);
    static int[] result3 = searchRange(new int[] { 2, 2 }, 3);
    static int[] result4 = searchRange(new int[] { 2, 2 }, 2);

    public static void main(String[] args) {
        System.out.println(String.format("%d, %d", result[0], result[1]));
        System.out.println(String.format("%d, %d", result2[0], result2[1]));
        System.out.println(String.format("%d, %d", result3[0], result3[1]));
        System.out.println(String.format("%d, %d", result4[0], result4[1]));
    }
}