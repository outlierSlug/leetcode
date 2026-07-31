<!--
number: 0080
title: Remove Duplicates From Sorted Array II
pattern: two-pointers
difficulty: Medium
languages: Java
slug: remove-duplicates-from-sorted-array-ii
last_reviewed: 2026-07-27
-->
# Remove Duplicates From Sorted Array II
[Problem Description](https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/)

Summary: Given a sorted integer array `nums`, remove some duplicates in-place such that each unique element appears at most twice.

## Algorithm
We will use two pointers: `k` will point at the index of the next potential unique element, and `i` will iterate through the array. Since we allow up to 2 consecutive identical elements, we have the following cases:
1. If `k == 0 || k == 1`, we keep the element and increment `k`. That is, we always keep the first two elements in the array.
2. Otherwise, if `nums[k-2] != nums[i]`, this means we have encountered a new element with at most two of the same element starting at index `k - 2`. Thus, we place this new element `nums[i]` at `k`, and increment `k`.

After the loop, we return `k` which is the number of resulting elements.

## Complexity

| Approach | Time | Space |
|---|---|---|
| Two Pointers | `O(n)` | `O(1)` |

## Notes
This problem is very similar to [Remove Element](../0027-remove-element/) and [Remove Duplicates From Sorted Array](../0026-remove-duplicates-from-sorted-array/).