import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) {
            return result;
        }

        Map<Character, String> numMap = new HashMap<>();
        numMap.put('2', "abc");
        numMap.put('3', "def");
        numMap.put('4', "ghi");
        numMap.put('5', "jkl");
        numMap.put('6', "mno");
        numMap.put('7', "pqrs");
        numMap.put('8', "tuv");
        numMap.put('9', "wxyz");

        backtrack(digits, 0, new StringBuilder(), result, numMap);
        return result;
    }

    private void backtrack(String digits, int index, StringBuilder current, 
                           List<String> result, Map<Character, String> numMap) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        String letters = numMap.get(digits.charAt(index));
        for (char letter : letters.toCharArray()) {
            current.append(letter);
            backtrack(digits, index + 1, current, result, numMap);
            current.deleteCharAt(current.length() - 1);
        }
    }
}