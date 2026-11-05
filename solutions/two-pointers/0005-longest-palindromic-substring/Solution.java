class Solution {
    public String longestPalindrome(String s) {
        int start = 0;  // the start index of the best palindromic substring
        int maxLength = 0;  // the length of the longest palindromic substring

        for (int i = 0; i < s.length(); i++) {
            // Case 1: odd-length palindrome centered around s[i]
            // Case 2: even-length palindrome centered around s[i] and s[i + 1]
            int odd = expand(s, i, i);
            int even = expand(s, i, i + 1);

            int length = Math.max(odd, even);
            if (length > maxLength) {
                start = i - (length - 1) / 2;
                maxLength = length;
            }
        }

        return s.substring(start, start + maxLength);
    }

    // Expands outwards from [left, right] while s[left] == s[right]. Returns the length of the palindrome found.
    private int expand(String s, int left, int right) {
        int length = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            length = right - left + 1;
            left--;
            right++;
        }
        return length;
    }
}