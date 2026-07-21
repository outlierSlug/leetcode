import java.util.*;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char d = t.charAt(i);

            if (!sMap.containsKey(c)) {
                sMap.put(c, i);
            }

            if (!tMap.containsKey(d)) {
                tMap.put(d, i);
            }

            if (!sMap.get(c).equals(tMap.get(d))) {
                return false;
            }
        }
        return true;
    }
}