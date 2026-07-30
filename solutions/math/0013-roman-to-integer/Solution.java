import java.util.Map;
import java.util.HashMap;

class Solution {
    public int romanToInt(String s) {
        String romanSymbols = "IVXLCDM";
        int[] romanValues = {1, 5, 10, 50, 100, 500, 1000};

        // Create symbol to value mapping
        Map<Character, Integer> romanMap = new HashMap<>();
        for (int i = 0; i < romanSymbols.length(); i++) {
            romanMap.put(romanSymbols.charAt(i), romanValues[i]);
        }

        // Initialize result with the last roman numeral, which is always added
        int result = romanMap.get(s.charAt(s.length() - 1));

        // Check numerals in pairs, if the preceding numeral is smaller, subtract its value, otherwise add it
        for (int i = 0; i < s.length() - 1; i++) {
            int val = romanMap.get(s.charAt(i));
            if (val < romanMap.get(s.charAt(i + 1))) {
                result -= val;
            } else {
                result += val;
            }
        }
        return result;
    }
}