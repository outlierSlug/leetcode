import java.util.Map;
import java.util.HashMap;

class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> charCounts = new HashMap<>();
        int result = 0;
        int left = 0;
        int maxFreq = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq, charCounts.get(c));

            // Shrink window until valid
            while ((right - left  + 1) - maxFreq > k) {
                char d = s.charAt(left);
                int count = charCounts.get(d);
                charCounts.put(d, count - 1);
                left++;
            }

            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}