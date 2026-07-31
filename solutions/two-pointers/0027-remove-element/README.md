<!--
number: 0027
title: Remove Element
pattern: two-pointers
difficulty: Easy
languages: Java
slug: remove-element
last_reviewed: 2026-07-24
-->
# Remove Element
[Problem Description](https://leetcode.com/problems/remove-element/description/)

Summary: Given an integer array `nums` and an integer `val`, remove all occurrence of `val` in `nums` *in-place*. The order of elements may be changed. Return the *number of element* in `nums` which are *not equal* to `val`.

## Algorithm
We will use a pointer `k` that points at the next valid index to put a non-`val` integer, starting at index `0`. Then, we will iterate through `nums`, and if `nums[i] != val`, then we place it at `k`, increment `k`, and continue looping. After the loop, all elements not equal to `val` will be placed at the first `k` indices, and all we need to do is simply return this value `k`.

## Complexity

| Approach | Time | Space |
|---|---|---|
| Two Pointers | `O(n)` | `O(1)` |

## Notes
This works because we do not need to preserve the original array whatsover. The non-`val` elements in `nums` are overriden and the elements past the first `k` indices are not important.