<!--
number: 0560
title: Subarray Sum Equals K
pattern: arrays-hashing
difficulty: Medium
languages: Java
slug: subarray-sum-equals-k
last_reviewed: 2026-10-01
-->
# Subarray Sum Equals K
[Problem Description](https://leetcode.com/problems/subarray-sum-equals-k/description/)

Summary: Given an integer array `nums` (which may contain negative numbers) and an integer `k`, return the number of contiguous subarrays whose sum equals `k`.

## Algorithm
Prefix sums with a hashmap. Let `sum` be the running total of `nums[0..i]`. The subarray `nums[j+1..i]` sums to `k` exactly when an earlier prefix sum equals `sum - k`. So at each index, the number of subarrays ending there with sum `k` is the number of earlier prefixes equal to `sum - k`.

A map `prefixSums` stores how many times each prefix sum has occurred. It starts with `{0: 1}`, the empty prefix, so subarrays starting at index 0 (where `sum` itself equals `k`) are counted.

For each element:
1. Add it to `sum`.
2. Add `prefixSums.get(sum - k)` (if present) to the result.
3. Record the current `sum` in the map.

Step 2 comes before step 3, so the current prefix is never matched with itself. Otherwise, with `k = 0`, an empty subarray would be counted.

## Complexity

| Time | Space |
|---|---|
| $O(n)$ | $O(n)$ |

One pass, with $O(1)$ map operations per element. The map holds up to $n + 1$ distinct prefix sums.

## Notes
- [Neetcode Solution](https://www.youtube.com/watch?v=fFVZt-6sgyo)
