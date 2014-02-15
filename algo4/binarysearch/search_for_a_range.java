public class search_for_a_range {

    public static int[] searchRange(int[] A, int target) {
        int[] range = { -1, -1 };

        int low = 0, high = A.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (A[mid] == target) {
                if (mid == 0 || A[mid - 1] < target) {
                    range[0] = mid;
                    low = mid;
                    high = A.length - 1;
                }

                if (mid == A.length - 1 || A[mid + 1] > target) {
                    range[1] = mid;
                    low = 0;
                    high = mid;
                }

                if (range[0] > -1 && range[1] > -1) {
                    return range;
                }

                if (range[0] < 0) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (A[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return range;
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