public class gas_station {
    public int canCompleteCircuit(int[] gas, int[] cost) {
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

    /**
     * Question:
     * 
     * There are N gas stations along a circular route, where the amount of gas at station i is
     * gas[i].
     * 
     * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station
     * i to its next station (i+1). You begin the journey with an empty tank at one of the gas
     * stations.
     * 
     * Return the starting gas station's index if you can travel around the circuit once, otherwise
     * return -1.
     * 
     * Solution:
     * 
     * There are two parts for this question. The first is whether there is a possible trip starting
     * off from a particular position in the circle such that we can finish the entire trip. The
     * second question is where this position is.
     * 
     * For the first question, we can sum up all the difference (subtract cost from gas) and see
     * whether this is negative or not.
     * 
     * For the second question, we can use a running sum for a sub-array. If the sum for range
     * [i..j] becomes smaller than zero, that means we cannot start off from any position between i
     * and j any more. That's because for any given k between i and j, sum(i to k) > 0, sum(i to j)
     * < 0, tour k + 1 to j will not be a possible tour.
     */
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
}