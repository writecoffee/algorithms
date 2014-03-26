public class gas_station {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int result = 0;
        int min = gas[0] - cost[0];
        int sum = min;

        for (int i = 1; i < n; i++) {
            sum += gas[i] - cost[i];
            if (sum < min) {
                min = sum;
                result = i;
            }
        }

        return sum >= 0 ? (result + 1) % n : -1;
    }

    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int n = gas.length;
        int k = 0;
        int lSum = 0;
        int gSum = 0;

        for (int i = 0; i < n; ++i) {
            lSum += gas[i] - cost[i];
            gSum += gas[i] - cost[i];

            if (lSum < 0) {
                lSum = 0;
                k = i + 1;
            }
        }

        return gSum < 0 ? -1 : k;
    }

    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[] { 10, 3, 6, 3, 4 }, new int[] { 9, 4, 3, 2, 4 }));
    }
}