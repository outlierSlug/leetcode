<!--
number: 0015
title: 3Sum
pattern: two-pointers
difficulty: Medium
languages: Java
slug: 3sum
last_reviewed: 2026-07-31
-->
# 3Sum
[Problem Description](https://leetcode.com/problems/3sum/description/)

Summary: Given an integer array `nums`, return all unique triplets such that every element has a unique index and the three numbers sum to `0`.

## Algorithm
A naive brute-force approach might attempt to check all possible triplets in the array. However, that is highly inefficient. We can derive a better solution via the following algorithm:

1. Sort the input array `nums` in ascending order. This will allow us to perform a Two Sum subproblem after fixing the first number in a potential triplet.
2. We will loop through the array starting with the first element, and ending at the `n-2`th element, as three numbers are required for a triplet.
    
    - If the current number being fixed is greater than `0`, then we can `break` out of the loop early, as due to the sorting there are no longer any possible triplets that can sum to `0`.
    - If we encounter a duplicate fixed number we have already processed, we simply `continue` and skip it as there will no longer be any unique triplets beyond those we have already found.
  
3. Then, we will perform a Two Sum subproblem. The first number is fixed at `nums[i]`, and we will have two pointers at index `i + 1` and `nums.length - 1` to check if their sum is `0`. If the sum is too small, we increment the `left` pointer to increase the sum, and if the sum is too large, we decrement the `right` pointer to decrease the sum. Note that this only works because the array `nums` is sorted. Once we find a valid triplet, we add it to the `result` list, and continue checking for any remaining triplets, skipping over duplicate `left` or `right` values.

## Complexity

| Time | Space |
|---|---|
| `O(n^2)`| `O(log n)` |

For each fixed `i`, the two-pointer sweep is `O(n)`, and we potentially check `O(n)` fixed first elements, giving the loop an overall time complexity of `O(n^2)`, which dominates runtime (the `sort` call is `O(n log n)`). As for space complexity, the `sort` call takes up `O(log n)` auxiliary space on the recrusion stack, as in Java it uses a dual-pivot quicksort.

## Notes
`List.of()` creates an immutable list.
