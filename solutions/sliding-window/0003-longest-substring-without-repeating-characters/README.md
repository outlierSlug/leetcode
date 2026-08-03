<!--
number: 0003
title: Longest Substring Without Repeating Characters
pattern: sliding-window
difficulty: Medium
languages: Java
slug: longest-substring-without-repeating-characters
last_reviewed: 2026-08-03
-->
# Longest Substring Without Repeating Characters
[Problem Description](https://leetcode.com/problems/longest-substring-without-repeating-characters/description/)

Summary: Given a string `s`, find the length of the longest substring without duplicate characters.

## Algorithm
We will use a HashMap to track the last seen index of every character in the string, and two pointers `left` and `right` to create a sliding window to find the longest substring without duplicates in a single pass. At every iteration, we check if the current character is already in the string. If it is and it is also within the current window, then we can move `left` to one index after the duplicate. Otherwise, we update the last seen index for that character and continue iterating `right`.
The longest substring is the max of the current `result` and the current window (`right - left  + 1`).

## Complexity

| Time | Space |
|---|---|
| `O(n)`| `O(min(n, k))` |

Note that `k` is the size of the character set, which is constant `O(1)` if we assume the set is only ASCII (128) characters.

## Notes
In practice, Java's `HashMap` operations are constant time on average, and we call a constant number of these operations per iteration through the string.
