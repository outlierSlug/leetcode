<!--
number: 0046
title: Permutations
pattern: backtracking
difficulty: Medium
languages: Java
slug: permutations
last_reviewed: 2026-09-09
-->
# Permutations
[Problem Description](https://leetcode.com/problems/permutations/description/)

Summary: Given an array `nums[]` of distinct integers, return all the possible permutations.

## Algorithm
We will use traditional backtracking pattern, including an extra `used[]` boolean array to track if a number has already been used for the `current` permutation being built.
At each recursive call:
- **Base case:** once `current.size() == nums.length`, every element has been placed, so we add a copy of `current` to `result`.
- **Recursive case:** for each index `i` in `nums[]` not yet marked `used`, choose it (add to `current`, mark `used[i] = true`), recurse, then un-choose (remove from `current`, mark `used[i] = false`) before trying the next unused index.

Because any unused index can be picked next regardless of position, this explores every ordering of the array.
## Complexity

| Time | Space |
|---|---|
| `O(n * n!)`| `O(n)` |

## Notes
- `used[]` replaces the `start` index from Combinations because permutations require revisiting any unused element regardless of its original position, while combinations only ever move forward through the array.
- Same copy-vs-reference rule as Combinations: `new ArrayList<>(current)` must be used when adding to `result`, since `current` is mutated and reused throughout the rest of the recursion.
- `n!` permutations are inherent to the problem; the extra `n` factor in time comes from copying each completed permutation into `result`.
