import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        if (words.length != pattern.length()) {
            return false;
        }

        Map<Character, String> charMap = new HashMap<>();
        Set<String> usedWords = new HashSet<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            if (charMap.containsKey(c)) {
                if (!charMap.get(c).equals(word)) {
                    return false;
                }
            } else {
                if (usedWords.contains(word)) {
                    return false;
                }
                charMap.put(c, word);
                usedWords.add(word);
            }
        }
        return true;
    }
}