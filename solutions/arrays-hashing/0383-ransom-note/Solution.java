import java.util.*;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // Use a map to track letters (keys)
        Map<Character, Integer> charMap = new HashMap<>();

        // Iterate through letters in magazine, if the letter is not in charMap, add it or increment its count
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);

            // Add to map pattern
            if (charMap.containsKey(c)) {
                int count = charMap.get(c);
                charMap.put(c, count + 1);
            } else {
                charMap.put(c, 1);
            }
        }

        // Iterate through letters in ransomNote, if a letter is in ransomNote but NOT in charMap, return false
        // If the count of a letter is more in ransomNote than in charMap, return false
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            
            if (!charMap.containsKey(c)) {
                return false;
            } 

            if (charMap.get(c) == 0) {
                return false;
            } else {
                int count = charMap.get(c);
                charMap.put(c, count - 1);
            }
        }
        // Otherwise, return true
        return true;
    }
}