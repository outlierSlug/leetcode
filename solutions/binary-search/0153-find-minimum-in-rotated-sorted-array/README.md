<!--
number: 0153
title: Find Minimum in Rotated Sorted Array
pattern: binary-search
difficulty: Medium
languages: Java
slug: find-minimum-in-rotated-sorted-array
last_reviewed: 2026-09-03
-->
# Find Minimum in Rotated Sorted Array
[Problem Description](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/)

Summary: Given a sorted array of distinct values `nums` rotated at an unknown pivot, find its minimum element.

## Algorithm
The rotated array `nums` is made up of two sorted runs, and the minimum is exactly the pivot where the second run begins. Binary search for that pivot by comparing `nums[mid]` against `nums[hi]`:
- If `nums[mid] > nums[hi]`, `mid` is still in the first (larger-valued) run. The minimum must be strictly to the right, so we narrow the search place to the right run: `lo = mid + 1`.
- Otherwise (`nums[mid] <= nums[hi]`), `mid` is already in the second run (or the array isn't rotated). In this case, `mid` itself could be the minimum, so it must stay in the search space: `hi = mid` (not `mid - 1`).

Loop while `lo < hi` (strict); when the loop exits, `lo == hi` has converged on the minimum.

## Complexity

| Time | Space |
|---|---|
| `O(log n)`| `O(1)` |

## Notes
- The two branches are asymmetric on purpose: `nums[mid] > nums[hi]` fully rules out `mid` as the answer, but `nums[mid] <= nums[hi]` does not rule `mid` in or out, it is still a candidate.
- The loop condition is strictly `lo < hi` taking the above into account to prevent an infinite loop.
