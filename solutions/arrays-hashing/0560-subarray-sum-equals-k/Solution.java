import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        // Map prefixSum -> count, initialize with implicit 0 prefix sum
        Map<Integer, Integer> prefixSums = new HashMap<>();
        prefixSums.put(0, 1);

        // Track the running sum across the entire array
        int sum = 0;
        for (int num : nums) {
            sum += num;

            // Calculate (sum - k), which is the diff equal to the prefix which can be removed to get a sum of k
            // using the current subarray
            int diff = sum - k;
            
            // If the diff exists in prefixSums, add its count to the overall result
            if (prefixSums.containsKey(diff)) {
                result += prefixSums.get(diff);
            }

            // Update prefixSums with the current subarray sum
            prefixSums.put(sum, prefixSums.getOrDefault(sum, 0) + 1);
        }

        return result;
    }
}