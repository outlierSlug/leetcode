<!--
number: 0048
title: Rotate Image
pattern: matrix
difficulty: Medium
languages: Java
slug: rotate-image
last_reviewed: 2026-08-31
-->
# Rotate Image
[Problem Description](https://leetcode.com/problems/rotate-image/description/)

Summary: Rotate an `n x n` matrix 90 degrees clockwise, in-place.

## Algorithm
We will decompose the rotation into two simpler in-place steps:

1. **Transpose** the matrix: swap elements across the main diagonal,i.e. `matrix[i][j]` with `matrix[j][i]` for all `i < j`.
2. **Reverse each row**: in place using a standard two-pointer swap.

This process is equivalent to a 90 degrees clockwise rotation.
## Complexity
Let `n` be the length of one side of the `n x n` matrix.

| Time | Space |
|---|---|
| `O(n^2)`| `O(1)` |

## Notes
- The reverse step reuses the Two Pointer in-place swap pattern for a single row in the matrix.
