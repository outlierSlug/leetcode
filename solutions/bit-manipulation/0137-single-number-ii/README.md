<!--
number: 0137
title: Single Number II
pattern: bit-manipulation
difficulty: Medium
languages: Java
slug: single-number-ii
last_reviewed: 2026-10-03
-->
# Single Number II
[Problem Description](https://leetcode.com/problems/single-number-ii/description/)

Summary: Given an integer array where every element appears exactly three times except for one, which appears once, find that element in $O(n)$ time and $O(1)$ extra space.

## Algorithm
Count bits position by position, taking each count mod 3.

XOR alone doesn't work here: `a ^ a ^ a = a`, so values that appear three times don't cancel out. Instead, look at one bit position at a time. Each value that appears three times adds either 0 or 3 to that position's count of 1s, a multiple of 3 either way. So `count % 3` **leaves exactly the single element's bi**t.

For each of the 32 bit positions `i`:
1. Count how many numbers have bit `i` set, using `(num >> i) & 1`.
2. If `count % 3 != 0`, the single element has bit `i` set, so turn it on in the result with `result |= 1 << i`.

## Complexity

| Time | Space |
|---|---|
| $O(n)$ | $O(1)$ |

Time complexity involves 32 passes over the array, $O(32n) = O(n)$. Space is constant.

## Notes
- **Bit operators used:**
  - `num >> i` shifts `num` right by `i` places, moving bit `i` into the last position.
  - `x & 1` keeps only the last bit, so `(num >> i) & 1` reads bit `i` as 0 or 1.
  - `1 << i` is a number with only bit `i` set.
  - `result |= x` is shorthand for `result = result | x`, which turns on every bit set in `x` and leaves the rest of `result` unchanged.
- **Negative numbers:** bit 31 is the sign bit. Reading it at `i = 31` and setting it with `1 << 31` produces the correct negative value.
- **Generalization:** if every other element appears `k` times, use `count % k`.
