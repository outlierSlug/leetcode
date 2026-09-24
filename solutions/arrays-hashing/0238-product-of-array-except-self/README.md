<!--
number: 0238
title: Product of Array Except Self
pattern: arrays-hashing
difficulty: Medium
languages: Java
slug: product-of-array-except-self
last_reviewed: 2026-09-23
-->
# Product of Array Except Self
[Problem Description](https://leetcode.com/problems/product-of-array-except-self/description/)

Summary: Given an integer array `nums`, return an array `answer` where `answer[i]` is the product of all elements of `nums` except `nums[i]`. Must run in `O(n)` time without using division; the `O(1)` extra space follow-up is also solved here (not counting the output array).

## Algorithm
We will perform two passes over `nums`, using the `result` array as storage to avoid extra space usage.

**Pass 1 (left to right):** build `result[i]` = product of everything strictly to the left of `i`, using a running `prefix` variable. `result[0] = 1` since nothing precedes it.

**Pass 2 (right to left):** multiply a running `postfix` variable (product of everything strictly to the right of `i`) into `result[i]` in-place. The multiplication must happen *before* updating `postfix` with `nums[i]`, otherwise `nums[i]` would incorrectly include itself in its own postfix product.

## Complexity

| Time | Space |
|---|---|
| $O(n)$ | $O(1)$ |

## Notes
- [Neetcode Solution](https://www.youtube.com/watch?v=bNvIQI2wAjk)
