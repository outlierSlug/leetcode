<!--
number: 0190
title: Reverse Bits
pattern: bit-manipulation
difficulty: Easy
languages: Java
slug: reverse-bits
last_reviewed: 2026-10-10
-->
# Reverse Bits
[Problem Description](https://leetcode.com/problems/reverse-bits/description/)

Summary: Reverse the bits of a given 32-bit signed integer.

## Algorithm
Walk through each bit position (0 to 31):

1. Extract bit `i` via `(n >> i) & 1`.
2. Place that bit at the mirrored position `31 - i` via `result |= bit << (31 - i)`.

## Complexity

| Time | Space |
|---|---|
| $O(1)$ | $O(1)$ |

## Notes
- Since `n` is non-negative and even, both bit 31 and bit 0 are 0, so the input and the output are both non-negative. The `& 1` mask would still handle negative inputs correctly, because only the bit pattern matters.
