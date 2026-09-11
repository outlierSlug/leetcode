<!--
number: 0051
title: N-Queens
pattern: backtracking
difficulty: Hard
languages: Java
slug: n-queens
last_reviewed: 2026-09-11
-->
# N-Queens
[Problem Description](https://leetcode.com/problems/n-queens/description/)

Summary: The n-queens puzzle is the problem of placing `n` queens on an `n x n` chessboard such that no two queens attack each other.

Given an integer `n`, return all distinct solutions to the n-queens puzzle. 

## Algorithm
We will use the same core backtracking algorithm as in [N-Queens II](../0052-n-queens-ii/), with two main changes since the actual boards are needed in the `result`, not just a count:

1. `placement[row] = col` tracks the column index that the queen on row index `row` was placed on.
2. In the base case, once `row == n`, we have to build the `List<String> board` using `placement[]` in a helper method `buildBoard` with StringBuilder. Then we add `board` to `result`. No copy is needed since the helper method returns a fresh object.

## Complexity

| Time | Space |
|---|---|
| `O(n!)`| `O(n)` |

## Notes
- Direct companion to N-Queens II. Same constraint logic, diagonal math, and pruning; the only new pieces are tracking `placement[]` and converting it to board strings at the base case.
- Space Complexity Distinction: the constraint sets, `placement[]`, and recursion depth stay `O(n)` throughout, same as N-Queens II. `buildBoard` adds a transient `O(n^2)` cost (n row-strings of length n) each time a solution completes, which becomes part of the output once added to `result`, not retained auxiliary state during the ongoing recursive descent.
