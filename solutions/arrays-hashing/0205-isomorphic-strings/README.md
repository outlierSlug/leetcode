# Isomorphic Strings
[Problem Description](https://leetcode.com/problems/isomorphic-strings/description/)

Summary: Given two strings `s` and `t`, return `true` if the characters in `s` can be replaced to get `t`, where each character in `s` maps to exactly one character in `t` and no two characters map to the same character (i.e. the mapping is one-to-one in both directions).

## Algorithm
We will use two hashmaps `sMap` and `tMap` where keys are *distinct characters* and values are the *index at which that character first appears*. First, we check that the two strings are the same length, since they cannot be isomorphic otherwise. Then, we iterate through the strings and build the maps accordingly. Each time we add a character, we compare the first-seen index of `s.charAt(i)` against the first-seen index of `t.charAt(i)`. If these do not match up, then the strings are not isomorphic as their is a mismatch in the mapping, and we return false.

## Complexity
Let `n = s.length()`.

| Approach | Time | Space |
|---|---|---|
| Hashmap | `O(n)` | `O(k)`

Note that `k` is the number of distinct characters, which is at most 26 for lowercase English letters, 128 for ASCII, or 256 for extended ASCII. In any case, the space complexity is essentially constant.

## Notes
Since the character set is bounded, it is also feasible to use two fixed-size arrays instead of hashmaps, which gives a guaranteed `O(1)` space complexity.