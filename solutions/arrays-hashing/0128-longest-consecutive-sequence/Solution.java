import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        int longest = 0;

        // Convert nums into a set
        for (int num : nums) {
            numSet.add(num);
        }

        // Check each num in the set, if (num - 1) doesn't exist, it is the start of a new LCS.
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int length = 0;
                while (numSet.contains(num + length)) {
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }
}