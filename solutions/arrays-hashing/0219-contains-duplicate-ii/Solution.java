import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // Map (num, index) where index is the most recently seen location.
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            // Add or update the index of the current num.
            if (!map.containsKey(num)) {
                map.put(num, i);
            } else {
                // If the last seen index of this repeat num is within the window, return true.
                if (Math.abs(i - map.get(num)) <= k) {
                    return true;
                }
                map.put(num, i);
            }
        }
        return false;
    }
}