import java.util.Map;
import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastSeen = new HashMap<>();
        int left = 0;
        int result = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // If the duplicate's last seen position is within the window, jump left to after it
            if (lastSeen.containsKey(c) && lastSeen.get(c) >= left) {
                left = lastSeen.get(c) + 1;
            }
            
            lastSeen.put(c, right);
            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}