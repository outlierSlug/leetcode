<!--
number: 0052
title: N-Queens II
pattern: backtracking
difficulty: Hard
languages: Java
slug: n-queens-ii
last_reviewed: 2026-09-11
-->
# N-Queens II
[Problem Description](https://leetcode.com/problems/n-queens-ii/description/)

Summary: The n-queens puzzle is the problem of placing `n` queens on an `n x n` chessboard such that no two queens attack each other.

Given an integer `n`, return the number of distinct solutions to the n-queens puzzle.

## Algorithm
We will place exactly one queen per row, processing rows in order. For each row, try every available column and skip any that conflicts with an already-placed queen. 

Three sets will track the invalid cells:
1. `cols`: A set tracking columns already used.
2. `posDiag`: Tracks the positive diagonal attack line of queens already placed. (y = x)
3. `negDiag`: Tracks the negative diagonal attack line of queens already placed (y = -x)

Both diagonal identities follow from the fact that moving along the positive diagonal leaves `row + col` unchanged, and moving along the negative diagonal leaves `row - col` unchanged.

Since only a `count` is needed (not the actual boards), each recursive call returns how many valid completions exist from its partial state, and results are summed up the call stack.

- **Base case:** `row == n` means every row has a validly-placed queen, so one complete solution has been found, return 1.
- **Recursive case:** for each column not conflicting with the three tracked constraints, choose it (add to all three sets), recurse to the next row, then un-choose (remove from all three sets).

## Complexity

| Time | Space |
|---|---|
| `O(n!)`| `O(n)` |

## Notes
- `O(n!)` reflects the column-permutation search space before diagonal pruning is applied. Diagonal constraints further prune this search in practice, but there's no simple closed-form for the resulting reduction, so `n!` is the standard bound stated.
- Space is `O(n)`: the three sets combined never hold more than one entry per currently-placed queen, and recursion depth is at most `n`.
- Sets were chosen over boolean arrays for simplicity: `row - col` can be negative, so a boolean-array version would need an offset to keep indices non-negative, whereas a set handles negative keys directly. Boolean arrays are a valid, slightly more performant alternative given `n` is typically small in this problem's constraints.