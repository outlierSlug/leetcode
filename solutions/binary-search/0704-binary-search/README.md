<!--
number: 0704
title: Binary Search
pattern: binary-search
difficulty: Easy
languages: Java
slug: binary-search
last_reviewed: 2026-09-02
-->
# Binary Search
[Problem Description](https://leetcode.com/problems/binary-search/description/)

Summary: Given a sorted array of integers `nums` and an integer `target`, run binary search to return the target's index, or `-1` if it's not found.

## Algorithm
We will maintain two pointers, `lo` and `hi`, starting at the two ends of the array, and will repeatedly halve the search space with binary search. After computing the midpoint `mid` between `lo` and `hi`, we perform the following checks:
1. If `nums[mid] == target`, we have found the target and return it's index, `mid`.
2. If `nums[mid] > target`, the target must be in the left half, so we set `hi = mid - 1`.
3. If `nums[mid] < target`, the target must be in the right half, so we set `lo = mid + 1`.

This continues while `lo <= hi`. If `target` is not found after this loop, we return `-1`.

## Complexity

| Time | Space |
|---|---|
| `O(log n)`| `O(1)` |

## Notes
- `mid` calculation uses `lo + (hi - lo) / 2` instead of `(lo + hi) / 2` to avoid integer overflow for very large index values.
- Both narrowing branches must move past `mid` (`mid - 1` / `mid + 1`), not land on it, otherwise it could potentially leave the search space unchanged and result in an infinite loop.
- The loop condition `lo <= hi` is inclusive because the search space can validly be one element that still needs to be checked.