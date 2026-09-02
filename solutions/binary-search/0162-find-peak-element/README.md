<!--
number: 0162
title: Find Peak Element
pattern: binary-search
difficulty: Medium
languages: Java
slug: find-peak-element
last_reviewed: 2026-09-02
-->
# Find Peak Element
[Problem Description](https://leetcode.com/problems/find-peak-element/description/)

Summary: Given an array where adjacent elements are never equal, find the index of any peak element, i.e. an element strictly greater than both of its neighbors.

## Algorithm
Binary search applies even though the array isn't globally sorted, because at each `mid` you can always decide which direction is guaranteed to contain a peak. The side with a larger element than the one at `mid` is guaranteed to have a peak, because the remaining search space is either monotonically increasing (guarantees peak at the endpoint) or it is not, meaning there is a peak somewhere.

At each `mid`, check its neighbors (guarding against out-of-bounds access at the array's edges, where it is implicitly `-infinity`):
- If `nums[mid] < nums[mid - 1]` (a larger element exists to the left), a peak must exist somewhere to the left. Narrow to `hi = mid - 1`.
- Else if `nums[mid] < nums[mid + 1]` (a larger element exists to the right), a peak must exist somewhere to the right. Narrow to `lo = mid + 1`.
- Otherwise, `mid` is greater than both neighbors. Return `mid` immediately.

## Complexity

| Time | Space |
|---|---|
| `O(log n)`| `O(1)` |

## Notes
- The trailing `return -1` after the loop is unreachable given the problem's guarantees: every iteration either shrinks the range or returns, and a finite array bounded by implicit `-infinity` on both sides is guaranteed to contain at least one peak, so the loop always returns before the range empties. It's only there so the compiler doesn't complain.
