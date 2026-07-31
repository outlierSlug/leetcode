<!--
number: 0026
title: Remove Duplicates From Sorted Array
pattern: two-pointers
difficulty: Easy
languages: Java
slug: remove-duplicates-from-sorted-array
last_reviewed: 2026-07-27
-->
# Remove Duplicates From Sorted Array
[Problem Descriptions](https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/)

Summary: Given a sorted integer array `nums`, remove the duplicates in-place such that each of the `k` unique element appears once.

## Algorithm
We will use two pointers: `k` points to the next possible index for the next unique element, and `i` will iterate through the array. In the loop, we have the following cases:
1. If `k == 0`, this is the first element and is unique by default. We keep the element at this index and increment `k`.
2. If `nums[k-1] != nums[i]`, this is the first instance of a new number different from the last already-placed unique element at index `k-1` (since index `k` points at the next possible index). Thus, we place this new element at index `k`, and increment `k`.
3. If neither of these cases hold, we simply skip the element (it is a repeat) until we find the next unique element, at which we do step 2 again.

We return `k` after the loop, which represents the number of unique element. Note that these elements are placed at indices `[0, k-1]`.

## Complexity

| Approach | Time | Space |
|---|---|---|
| Two Pointers | `O(n)` | `O(1)` |

## Notes
This problem is very similar to [Remove Element](../0027-remove-element/).