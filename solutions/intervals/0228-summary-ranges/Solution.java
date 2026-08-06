import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];
            while (i + 1 < nums.length && nums[i] + 1 == nums[i + 1]) {
                i++;
            }
            int end = nums[i];
            if (start != end) {
                result.add(start + "->" + end);
            } else {
                result.add(String.valueOf(start));
            }
        }
        return result;
    }
}