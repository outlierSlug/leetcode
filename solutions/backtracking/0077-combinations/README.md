<!--
number: 0077
title: Combinations
pattern: backtracking
difficulty: Medium
languages: Java
slug: combinations
last_reviewed: 2026-09-09
-->
# Combinations
[Problem Description](https://leetcode.com/problems/combinations/description/)

Summary: Given two integers `n` and `k`, return all possible combinations of `k` numbers chosen from the range `[1, n]`.

## Algorithm
We will use the traditional backtracking pattern, choosing numbers in strictly increasing order to avoid producing duplicate combinations.

Track a `start` value at each recursive call: only numbers `>= start` are eligible to be chosen next. When a number `num` is chosen, the next recursive call passes `num + 1` as its `start`, guaranteeing every number in a combination is strictly greater than the one before it.

- **Base case:** once `current.size() == k`, a complete combination has been built. Add a *copy* of `current` to `result` (not `current` itself, since it's mutated and reused across the rest of the recursion).
- **Recursive case:** for each candidate `num` from `start` to `n`, choose it, recurse with `start = num + 1`, then un-choose (backtrack) before trying the next candidate.

## Complexity

| Time | Space |
|---|---|
| `O(k * C(n,k))`| `O(k)` |

## Notes
- **Pruning:** the loop can stop early once there aren't enough remaining numbers to reach size `k`. If `remaining = k - current.size()` more numbers are needed, `num` only needs to range up to `n - remaining + 1`. Beyond that, not enough candidates remain in `[num, n]` to ever complete a valid combination.
- `C(n,k)` combinations are inherent to the problem; the `k` factor comes from copying each completed combination (`O(k)` per copy) into `result`.
- Adding `current` directly instead of `new ArrayList<>(current)` is a classic bug in this pattern: since `current` keeps getting mutated (append/remove) throughout the rest of the recursion, a reference stored without copying would end up reflecting whatever `current` happens to look like at the very end, not the state at the moment it was added.