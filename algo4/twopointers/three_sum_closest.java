import java.util.Arrays;

public class three_sum_closest {
    public static int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int result = num[0] + num[1] + num[2];

        for (int i = 0; i < num.length - 2; i++) {
            int j = i + 1;
            int k = num.length - 1;

            while (j < k) {
                int threeSum = num[i] + num[j] + num[k];

                if (threeSum == target) {
                    return threeSum;
                } else if (threeSum < target) {
                    j++;
                } else {
                    k--;
                }

                if (Math.abs(result - target) > Math.abs(threeSum - target)) {
                    result = threeSum;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[] { 0, 1, 2 }, 0));
    }
}