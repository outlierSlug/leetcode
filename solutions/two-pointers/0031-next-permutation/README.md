<!--
number: 0031
title: Next Permutation
pattern: two-pointers
difficulty: Medium
languages: Java
slug: next-permutation
last_reviewed: 2026-10-11
-->
# Next Permutation
[Problem Description](https://leetcode.com/problems/next-permutation/description/)

Summary: Given an integer array `nums`, rearrange it in place into the next lexicographically greater permutation. If it is already the largest permutation, rearrange it into the smallest (sorted ascending). Use only constant extra memory.

## Algorithm
The smallest possible increase comes from changing the rightmost position that can still increase, by as little as possible, and then making everything after it as small as possible.

1. **Find the pivot.** Going from right to left, find the first element at index `i` that is smaller than the element to the right of it at index `i + 1`. That’s the pivot.
2. **Swap with the next-larger element.** Since the suffix is is decreasing from left to right, the first element from the right that is greater than `nums[i]` is the smallest such element. Swap them.
3. **Reverse the suffix.** The suffix is still non-increasing after the swap, so reversing it makes it ascending, its smallest arrangement.

If no pivot exists (`i == -1`), the whole array is non-increasing (the largest permutation). Skip the swap, and reversing from index 0 wraps around to the smallest permutation.

For `[1,3,5,4,2]`: the pivot is `3` (index 1), the next-larger element in `[5,4,2]` is `4`. Swapping gives `[1,4,5,3,2]`, and reversing the suffix gives `[1,4,2,3,5]`.

Helpers: `swap(nums, i, j)` uses a temporary variable, and `reverse(nums, start)` reverses `nums[start..n-1]` with two pointers moving toward each other.

## Complexity

| Time | Space |
|---|---|
| $O(n)$ | $O(1)$ |

## Notes
- **Duplicates need `>=` in the pivot scan:** the loop must skip while `nums[i] >= nums[i + 1]`, because equal values belong to the non-increasing suffix. With `>`, `[2,3,3]` stops at the second `3`, finds no larger element to swap with, and `j` runs out of bounds. The swap scan correctly uses `nums[j] <= nums[i]`, and it always stops because a valid pivot has a larger element to its right.
- **Why reversing is the same as sorting:** after the swap, elements left of `j` are `>= nums[j] > old pivot`, and elements right of `j` are `<= old pivot`. Placing the old pivot at `j` keeps the suffix non-increasing, so a reversal sorts it in $O(n)$ instead of $O(n \log n)$.
- **Why `i` starts at `n - 2`:** the scan compares `nums[i]` with `nums[i + 1]`, and the last element can't be a pivot since nothing is to its right. For `n = 1`, `i = -1`, so the loop and swap are skipped and the reverse does nothing.
