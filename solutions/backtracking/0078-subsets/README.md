<!--
number: 0078
title: Subsets
pattern: backtracking
difficulty: Medium
languages: Java
slug: subsets
last_reviewed: 2026-09-23
-->
# Subsets
[Problem Description](https://leetcode.com/problems/subsets/description/)

Summary: Given an integer array `nums` of unique elements, return all possible subsets (the power set). The solution set must not contain duplicate subsets.

## Algorithm
Classic backtracking, framed as a decision tree with one level per element of `nums`. At each element, there are exactly two choices: include it in the current subset, or exclude it. Since there are `n` elements each with 2 independent choices, the tree has `2^n` leaves, matching the total number of subsets.

A recursive helper tracks three things: `index` (which element is currently being decided on), `current` (the partial subset built so far), and `result` (the accumulated list of completed subsets).

**Base case:** `index == nums.length` means every element has been decided on, so `current` represents one complete subset. It is copied via `new ArrayList<>(current)` before being added to `result`, since adding `current` directly would let later mutations corrupt every previously saved subset (they all reference the same list object otherwise).

**Recursive case:** the "include" branch adds `nums[index]` to `current`, recurses to `index + 1`, then removes it again once that recursive call returns. This undo step is the defining feature of backtracking: it resets `current` to its prior state so the following "exclude" branch (which simply recurses to `index + 1` without adding anything) starts from a clean slate rather than incorrectly carrying `nums[index]` forward.

## Complexity

| Time | Space |
|---|---|
| $O(n \cdot 2^n)$ | $O(n)$ |

## Notes
- **Auxiliary vs. output space**: the `O(n)` figure only covers extra working memory (call stack and `current`), not the unavoidable `O(n * 2^n)` needed to store the required output.