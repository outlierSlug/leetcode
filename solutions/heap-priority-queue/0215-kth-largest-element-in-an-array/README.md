<!--
number: 0215
title: Kth Largest Element in an Array
pattern: heap-priority-queue
difficulty: Medium
languages: Java
slug: kth-largest-element-in-an-array
last_reviewed: 2026-09-05
-->
# Kth Largest Element in an Array
[Problem Description](https://leetcode.com/problems/kth-largest-element-in-an-array/description/)

Summary: Given an integer array `nums` and an integer `k`, return the k-th largest element in the array.

## Algorithm
We will maintain a min-heap of size `k`. In a single pass through the array, we add each element. Whenever the min-heap exceeds size `k`, we `poll` (remove) the root which is the smallest number so far. Thus, at the end of the loop, the remaining `k` elements in the min-heap are the `k` largest, with the root given by `peek` being the k-th largest.

## Complexity

| Time | Space |
|---|---|
| `O(n log(k))`| `O(k)` |

## Notes
- Use an enhanced for-loop to avoid making errors with a manual index loop.
- Beats the naive "sort the whole array" approach (`O(n log n)`) when `k` is small relative to `n`.
