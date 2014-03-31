public class max_and_min {
    public static class Result {
        public final int min;
        public final int max;

        Result(int _min, int _max) {
            min = _min;
            max = _max;
        }
    }

    /**
     * Time complexity is O(n). But T(n) = ceiling(3n / 2) - 2.
     * 
     *        T(n) = 2T(n / 2) + 2
     *             = 2(ceiling(3(n / 2) / 2) - 2) + 2
     *             = ceiling(3n / 2) - 2
     * 
     */
    static Result maxmin(int[] array) {
        assert array != null;
        assert array.length > 0;
        return explore(array, 0, array.length);
    }

    static Result explore(int[] array, int start, int end) {
        int n = end - start;

        if (n == 1) {
            return new Result(array[start], array[start]);
        } else if (n == 2) {
            return new Result(Math.min(array[start], array[start + 1]),
                              Math.max(array[start], array[start + 1]));
        } else {
            int mid = start + (end - start) / 2;
            Result l = explore(array, start, mid);
            Result r = explore(array, mid, end);

            return new Result(Math.min(l.min, r.min),
                              Math.max(l.max, r.max));
        }
    }
}