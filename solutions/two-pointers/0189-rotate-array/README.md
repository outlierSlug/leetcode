<!--
number: 0189
title: Rotate Array
pattern: two-pointers
difficulty: Medium
languages: Java, Python
slug: rotate-array
last_reviewed: 2026-10-02
-->
# Rotate Array
[Problem Description](https://leetcode.com/problems/rotate-array/description/)

Summary: Given an integer array `nums`, rotate it to the right by `k` steps in place.

## Algorithm
Three in-place reversals. Rotating right by `k` moves the last `k` elements to the front while keeping each block's internal order:

1. Reverse the entire array. The last `k` elements are now at the front, but each block is backward.
2. Reverse the first `k` elements to restore that block's order.
3. Reverse the remaining `n - k` elements to restore that block's order.

For `[1,2,3,4,5,6,7]` with `k = 3`: reversing everything gives `[7,6,5,4,3,2,1]`, reversing the first 3 gives `[5,6,7,4,3,2,1]`, and reversing the last 4 gives `[5,6,7,1,2,3,4]`.

First, `k = k % n`, since rotating by `n` returns the array to its original order, so only the remainder matters.

A helper `reverse(arr, l, r)` reverses the subarray `[l, r]` (both ends included) with two pointers moving toward each other, swapping through a temporary variable.

## Complexity

| Time | Space |
|---|---|
| $O(n)$ | $O(1)$ |

Each element is swapped about twice across the three reversals. Everything happens in place.

## Notes
- **Why `k % n`:** without it, a `k` larger than `n` makes `reverse(nums, 0, k - 1)` go out of bounds. It also assumes the array isn't empty, which LeetCode guarantees, because `k % 0` throws an `ArithmeticException`.
- **`k == 0` after the mod:** the first `reverse(nums, 0, -1)` does nothing, since `l < r` is false, and the last reversal undoes the first. The array correctly comes out unchanged.
- **Java vs Python swaps:** Java has no tuple swap like `a, b = b, a`, so swapping uses a temporary variable. `Collections.reverse` only works on `List`s, not `int[]`, so writing the loop is standard.
- **Left rotation by `k`:** reverse the first `k`, reverse the remaining `n - k`, then reverse the whole array. Equivalently, rotate right by `n - k`.