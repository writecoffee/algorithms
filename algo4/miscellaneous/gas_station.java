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

    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[] { 10, 3, 6, 3, 4 }, new int[] { 9, 4, 3, 2, 4 }));
    }
}