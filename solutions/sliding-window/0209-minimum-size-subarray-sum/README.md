<!--
number: 0209
title: Minimum Size Subarray Sum
pattern: sliding-window
difficulty: Medium
languages: Java
slug: minimum-size-subarray-sum
last_reviewed: 2026-08-03
-->
# Minimum Size Subarray Sum
[Problem Description](https://leetcode.com/problems/minimum-size-subarray-sum/description/)

Summary: Given an array of positive integers `nums` and a positive integer `target`, return the minimal length of a subarray whose sum is greater than or equal to `target`. If there is no such subarray, return `0`.

## Algorithm
We will use two pointers, `left` and `right`, to create a sliding window that tracks the `windowSum` and the `minLength`. The `right` pointer will iterate through the array, and add the current value to the `windowSum`. If `windowSum >= target`, we record the current length and update `minLength` if the current window length is smaller. Then, we attempt to shrink the window as much as possible by incrementing `left`, which can only strictly decrease the `windowSum`. After the loop, we return `minLength` if a valid subarray was found, otherwise we return `0`.

## Complexity

| Time | Space |
|---|---|
| `O(n)`| `O(1)` |

The total work within the loop is `O(n)` time, as the total number of `left` and `right` increments is bounded by `n`, since each increment is a permanent action. Thus, the total work is `O(n) + O(n) = O(n)`.

## Notes
`Integer.MAX_VALUE` acts as a "unfound" sentinal, resolved at the end with a ternary operator.
