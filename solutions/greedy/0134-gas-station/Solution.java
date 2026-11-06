class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // If sum(gas) < sum(cost), return -1 immediately
        int total = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i];
            total -= cost[i];
        }
        if (total < 0) return -1;

        int tank = 0;
        int start = 0;  // current start candidate index

        for (int i = 0; i < gas.length; i++) {
            int net = gas[i] - cost[i];
            tank += net;

            // Can't reach station i + 1 from start, so no station in [start, i] works as start
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        
        return start;
    }
}