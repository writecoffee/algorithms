public class find_magic_index {
    public static int find(int[] array) {
        return find(array, 0, array.length);
    }

    private static int find(int[] array, int start, int end) {
        int i = start;
        int j = end - 1;

        while (i <= j) {
            int mid = (i + j) / 2;
            if (array[mid] == mid) {
                return mid;
            } else if (array[mid] < mid) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }

        return -1;
    }

    public static int findFollowup(int[] array) {
        return findFollowup(array, 0, array.length);
    }

    private static int findFollowup(int[] array, int start, int end) {
        int i = start;
        int j = end - 1;

        if (i > j) {
            return -1;
        }

        int mid = (i + j) / 2;

        if (mid == array[mid]) {
            return mid;
        }

        int intermediateResult;
        if (array[mid] < mid) {
            intermediateResult = findFollowup(array, mid + 1, end);
            if (intermediateResult == -1) {
                return findFollowup(array, start, mid - 1);
            }
        } else {
            intermediateResult = findFollowup(array, start, mid - 1);
            if (intermediateResult == -1) {
                return findFollowup(array, mid + 1, end);
            }
        }

        return intermediateResult;
    }

    public static void main(String[] args) {
        int[] array = new int[] { 1, 2, 3, 4, 5, 9 };
        int[] array2 = new int[] { -10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13 };
        System.out.println(find(array));
        System.out.println(findFollowup(array2));
    }
}