import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        // Needed characters from t: char -> count
        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        
        // Character counts in the current window
        Map<Character, Integer> window = new HashMap<>();

        int need = tMap.size();  // distinct characters needed to be satisfied
        int have = 0;  // current number of distinct characters satisfied

        int minLength = Integer.MAX_VALUE;
        int startIndex = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            // Add the current character to the window if it's in tMap
            char c = s.charAt(right);
            if (tMap.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);

                // If the window now has enough of char c in t, increment have
                if (window.get(c).equals(tMap.get(c))) {
                    have++;
                }
            }

            // While we have a valid window, shrink from the left
            while (have == need) {
                // Record the current window
                int length = right - left + 1;
                if (length < minLength) {
                    startIndex = left;
                    minLength = length;
                }

                // Remove s[left] from the window, then increment left
                char leftChar = s.charAt(left);
                if (tMap.containsKey(leftChar)) {
                    window.put(leftChar, window.get(leftChar) - 1);

                    // Decrement have if the count of this character no longer makes the window valid
                    if (window.get(leftChar) < tMap.get(leftChar)) {
                        have--;
                    }
                }
                
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLength);
    }
}