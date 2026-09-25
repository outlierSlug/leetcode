<!--
number: 0128
title: Longest Consecutive Sequence
pattern: arrays-hashing
difficulty: Medium
languages: Java
slug: longest-consecutive-sequence
last_reviewed: 2026-09-24
-->
# Longest Consecutive Sequence
[Problem Description](https://leetcode.com/problems/longest-consecutive-sequence/description/)

Summary: Given an unsorted array of integers `nums`, return the length of the longest run of consecutive integers (not necessarily contiguous in the array, and not necessarily sorted as given). Must run in `O(n)` time.

## Algorithm
Convert `nums` into a `HashSet<Integer>` for O(1) membership checks and to remove duplicates. For each number in the set, check whether it's the *start* of a sequence by testing `numSet.contains(num - 1)`. Only starts trigger an inner counting loop, which walks forward (`num`, `num + 1`, `num + 2`, ...) as long as consecutive values exist in the set.

## Complexity

| Time | Space |
|---|---|
| $O(n)$ | $O(n)$ |

## Notes
- The `num - 1` guard is what keeps this `O(n)` overall rather than `O(n^2)`: without it, every number would redundantly re-walk sequences that a smaller number already covered. With it, the inner `while` loop only ever begins at a true sequence start, so across the entire outer loop, every element is visited by the inner loop at most once (as part of the single sequence it belongs to).
