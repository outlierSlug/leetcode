import java.util.Map;
import java.util.HashMap;

class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char d = t.charAt(i);
            if (sMap.containsKey(c)) {
                int count = sMap.get(c);
                sMap.put(c, count + 1);
            } else {
                sMap.put(c, 1);
            }
            if (tMap.containsKey(d)) {
                int count = tMap.get(d);
                tMap.put(d, count + 1);
            } else {
                tMap.put(d, 1);
            }
        }

        for (char key : sMap.keySet()) {
            if (!sMap.get(key).equals(tMap.get(key))) {
                return false;
            }
        }
        return true;
    }
}