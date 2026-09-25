<!--
number: 0219
title: Contains Duplicate II
pattern: arrays-hashing
difficulty: Easy
languages: Java
slug: contains-duplicate-ii
last_reviewed: 2026-09-24
-->
# Contains Duplicate II
[Problem Description](https://leetcode.com/problems/contains-duplicate-ii/description/)

Summary: Given an integer array `nums` and an integer `k`, return `true` if there are two distinct indices `i` and `j` in the array such that `nums[i] == nums[j]` and `abs(i - j) <= k`.

## Algorithm
Use a map where keys are numbers and values are the index that number was last seen. Perform a single pass through the array, and either add or update the index of the current number being processed. 

If the last seen index of a repeat number is within the window, return `true`. Otherwise, if no such window is encountered after the loop, return `false`.

## Complexity

| Time | Space |
|---|---|
| $O(n)$ | $O(n)$ |

## Notes
- Space complexity is bounded by the number of distinct keys (numbers) placed in the map.
