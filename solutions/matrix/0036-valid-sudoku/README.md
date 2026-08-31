<!--
number: 0036
title: Valid Sudoku
pattern: matrix
difficulty: Medium
languages: Java
slug: valid-sudoku
last_reviewed: 2026-08-30
-->
# Valid Sudoku
[Problem Description](https://leetcode.com/problems/valid-sudoku/description/)

Summary: Given a partially filled 9x9 Sudoku board, determine whether the current filled cells form a valid Sudoku grid.

## Algorithm
We will perform a single pass over all 81 cells, maintaining an array of sets for the 9 rows, 9 columns, and 9 3x3 boxes that make up the entire board. 

For each filled cell with digit `c`:
1. Compute its box index by flattening the 2D box coordinate `(row / 3, col /3)` into a single index, `boxIndex = (row / 3) * 3 + (col / 3).`
2. Return false if `c` is already in `rows[row], cols[col], boxes[boxIndex]`, since that means there is a duplicate.
3. Otherwise, add `c` to all three sets and move to the next filled cell.

## Complexity

| Time | Space |
|---|---|
| `O(1)`| `O(1)` |

## Notes
- The board size is fixed (9x9 = 81 cells), so both time and space complexity are constant.
- Box-index flattening (`(row/3)*3 + (col/3)`) is the standard trick for mapping a 2D "box coordinate" into a 1D array index.
- In Python, a `dict` keyed directly by the tuple `(row//3, col//3)` works just as well and avoids the flattening step, since tuples are hashable. Java arrays require integer indices, so flattening is necessary there.
