<!--
number: 0034
title: Find First and Last Position of Element in Sorted Array
pattern: binary-search
difficulty: Medium
languages: Java
slug: find-first-and-last-position-of-element-in-sorted-array
last_reviewed: 2026-09-04
-->
# Find First and Last Position of Element in Sorted Array
[Problem Description](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/)

Summary: Given an array of integers `nums` sorted in non-decreasing order, find the starting and ending position of a given `target` value. If `target` is not found in the array, return `[-1, -1]`.

## Algorithm
A single binary search only finds *some* occurrence of `target`, with no control over which one when duplicates exist. Thus, we will run two directional binary searches instead, via a shared helper function `binSearch(nums, target, leftBias)`:

- On finding `nums[mid] == target`, record it as the current best `result`, then **keep narrowing** instead of returning immediately,  toward `hi = mid - 1` if biased left (searching for the first occurrence), or `lo = mid + 1` if biased right (searching for the last).
- Non-matching cases narrow exactly as in vanilla binary search.
- `result` ends up holding the leftmost or rightmost matching index once the loop exits (or stays `-1` if no match was ever found).

Call the helper twice, once with `leftBias=true`, once with `false`, and return `[first, last]`.

## Complexity

| Time | Space |
|---|---|
| `O(log n)`| `O(1)` |

## Notes
- Calling the `O(log n)` helper twice is still `O(log n)` overall.
