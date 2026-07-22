# Valid Anagram
[Problem Description](https://leetcode.com/problems/valid-anagram/description/)

Summary: Given two strings `s` and `t`, return `true` if `t` is an anagram of `s`.

## Algorithm
My intuition for this problem led me to use two hashmaps to track the counts of letters in each string, then compare the counts and return false if there is any mismatch. 

However, there are also other solutions, such as just using one hashmap or a fixed-size array. 

## Complexity

| Approach | Time | Space |
|---|---|---|
| Hashmap | `O(n)` | `O(k)` |
| Array | `O(n)` | `O(1)` |

Note that `k` is the number of distinct characters, which is at most 26 for lowercase English letters and is essentially constant. 

## Notes
Always use `.equals()` when comparing `Integer` objects, such as the values in a map.

A potential solution using a fixed-size array is very effective, as there is no hashing overhead and guaranteed `O(1)` space complexity. Consider the code:

```java
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        int count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int c : count) {
            if (c != 0) return false;
        }
        return true;
    }
}
```

Note that the `- 'a'` indexing trick is used since `char` in Java is stored as an underlying Unicode value, so we can do this to make sure the indices are zero-indexed.