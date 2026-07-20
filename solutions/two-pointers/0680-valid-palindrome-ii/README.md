# Valid Palindrome II
[Problem Description](https://leetcode.com/problems/valid-palindrome-ii/description/)

Summary: Given a string `s`, return `true` if `s` is a palindrome after deleting at most one character from it.

## Algorithm

We will use two pointers, one at each end of the string, and compare each character until we meet in the middle. The first time we encounter a mismatch, we make a call to a helper method that checks if the string `s` is still a palindrome after removing the current character at `lo` or at `hi`. If so, we return true. Otherwise, we return false.

## Complexity

| Approach | Time | Space |
|---|---|---|
| Two Pointers | `O(n)` | `O(1)` |

## Notes
It is assumed the string `s` only contains lowercase English characters.