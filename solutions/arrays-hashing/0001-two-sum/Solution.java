import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(target - num)) {
                int[] result = {map.get(target - num), i};
                return result;
            }
            map.put(num, i);
        }
        throw new IllegalArgumentException("No solution found.");
    }
}