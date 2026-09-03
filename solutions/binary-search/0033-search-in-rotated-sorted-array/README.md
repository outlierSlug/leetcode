<!--
number: 0033
title: Search in Rotated Sorted Array
pattern: binary-search
difficulty: Medium
languages: Java
slug: search-in-rotated-sorted-array
last_reviewed: 2026-09-03
-->
# Search in Rotated Sorted Array
[Problem Description](https://leetcode.com/problems/search-in-rotated-sorted-array/description/)

Summary: Given a sorted array of distinct values `nums` rotated at an unknown pivot, determine if `target` exists in `nums` and return its index. Otherwise, return `-1`.

## Algorithm
We will perform a modified version of binary search. At each `mid`, first check `nums[mid] == target` directly. Otherwise, determine which half of the current range is properly sorted, then check whether `target` falls within that sorted half's value range:

- If `nums[lo] <= nums[mid]`, the left half (`lo` to `mid`) is sorted. If `nums[lo] <= target < nums[mid]`, `target` is in that range and we narrow to `hi = mid - 1`. Otherwise `target` must be in the right half, and we narrow to `lo = mid + 1`.
- Otherwise, the right half (`mid` to `hi`) is sorted. If `nums[mid] < target <= nums[hi]`, narrow to `lo = mid + 1`. Otherwise narrow to `hi = mid - 1`.

Loop while `lo <= hi`. If `target` is not found after this loop, return `-1`.

## Complexity

| Time | Space |
|---|---|
| `O(log n)`| `O(1)` |

## Notes
- It is helpful to use an example or visualization to understand the algorithm. The key point is that you simply need to find the sorted half with `target` potentially inside it, using binary search to efficiently narrow the search space.
