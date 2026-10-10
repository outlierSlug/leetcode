<!--
number: 0338
title: Counting Bits
pattern: bit-manipulation
difficulty: Easy
languages: Java
slug: counting-bits
last_reviewed: 2026-10-10
-->
# Counting Bits
[Problem Description](https://leetcode.com/problems/counting-bits/description/)

Summary: Given `n`, return an array `ans` of length `n + 1` where `ans[i]` is the number of 1-bits in the binary representation of `i`.


## Algorithm
DP solution over `i` from 1 to `n`:

- `bits[i] = bits[i >> 1] + (i & 1)`
- `i >> 1` is `i` with its lowest bit dropped. It is smaller than `i`, so its count is already in the table.
- `i & 1` is the dropped lowest bit, which adds 0 or 1.
- Base case: `bits[0] = 0`.

## Complexity

| Time | Space |
|---|---|
| $O(n)$ | $O(1)$ |

## Notes

