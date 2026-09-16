<!--
number: 0022
title: Generate Parentheses
pattern: backtracking
difficulty: Medium
languages: Java
slug: generate-parentheses
last_reviewed: 2026-09-15
-->
# Generate Parentheses
[Problem Description](https://leetcode.com/problems/generate-parentheses/description/)

Summary: Given `n` pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

## Algorithm
We will use backtracking with two choices at each step (choose `'('` or `')'`), and prune via two counts `open` and `close`.

**Base Case**: `current.length() == 2 * n`, i.e. the current string being built consists of exactly `open + close` or a full string with `n` pairs of balanced parentheses.

**Recursive Case**: 
- Choose `'('` if `open < n`, meaning we haven't used all `n` opening parentheses yet.
- Choose `')'` if `close < open`, which means we never have more closing parentheses than opening parentheses so far in `current`. 

Two sequential `if` blocks (rather than a `for` loop) suffice because the branching factor is fixed at exactly 2 choices per step; a loop is only needed when the candidate set varies in size.

## Complexity

| Time | Space |
|---|---|
| `O(n * Catalan(n))`| `O(n)` |

The number of valid balanced strings for `n` pairs is exactly the `n`-th Catalan number.
## Notes
- The time complexity of this problem is also commonly stated as  `O(4^n / sqrt(n))`.
