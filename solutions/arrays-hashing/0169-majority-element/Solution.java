import java.util.Map;
import java.util.HashMap;

class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (numsMap.containsKey(num)) {
                int count = numsMap.get(num);
                numsMap.put(num, count + 1);
            } else {
                numsMap.put(num, 1);
            }
        }
        int max = 0;
        int majorityElem = 0;
        for (int key : numsMap.keySet()) {
            if (numsMap.get(key) > max) {
                majorityElem = key;
                max = numsMap.get(key);
            }
        }
        return majorityElem;
    }
}