import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] strArray = str.toCharArray();
            Arrays.sort(strArray);
            String strKey = new String(strArray);
            if (!map.containsKey(strKey)) {
                map.put(strKey, new ArrayList<>());
            }
            map.get(strKey).add(str);
        }
        return new ArrayList<>(map.values());
    }
}