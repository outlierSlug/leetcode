# Ransom Note
[Problem Description](https://leetcode.com/problems/ransom-note/description/)

Summary: Given two strings `ransomNote` and `magazine`, return `true` if `ransomNote` can be constructed by using the letters from `magazine`.

## Algorithm
We will use a hashmap to track the usable letters from `magazine`, where each letter has a count that indicates how many times it appears in `magazine`. Then, we will iterate through the letters of `ransomNote` and check if it can be constructed using the letters in the hashmap.

## Complexity

Let `m = magazine.length()` and `n = ransomNote.length()`. 

| Approach | Time | Space |
|---|---|---|
| Hashmap | `O(m + n)` | `O(k)` |

Note that `k` is the number of distinct characters, which is at most 26 for lowercase English letters and is essentially constant.

## Notes
Since there are only 26 possible keys, it is also feasible to use an array instead of a hashmap to track letters, which gives a guaranteed `O(1)` space complexity.