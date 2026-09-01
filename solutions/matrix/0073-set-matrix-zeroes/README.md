<!--
number: 0073
title: Set Matrix Zeroes
pattern: matrix
difficulty: Medium
languages: Java
slug: set-matrix-zeroes
last_reviewed: 2026-08-31
-->
# Set Matrix Zeroes
[Problem Description](https://leetcode.com/problems/set-matrix-zeroes/description/)

Summary: Given an `m x n` matrix, if any element is `0`, set its entire row and column to `0`, in-place.

## Algorithm
Naively zeroing cells as soon as a `0` is found creates new zeros that get misread as original ones on later scans. We will avoid this by first recording which rows/columns need zeroing, then applying the zeroing in a separate pass.

1. Before any mutation, check whether the first row and first column originally contain any zero and save each as a boolean (`firstRowHasZero`, `firstColHasZero`). Two flags are needed since both the first row and first column get repurposed as marker/flag storage for each other's dimension.
2. Scan the interior (excluding the first row and column). For any `matrix[row][col] == 0`, flag it by setting `matrix[row][0] = 0` and `matrix[0][col] = 0`.
3. Scan the interior again. For each cell, zero it out if `matrix[row][0] == 0` or `matrix[0][col] == 0` (i.e. its row or column was flagged).
4. Only now, zero out the first row entirely if `firstRowHasZero`, and the first column entirely if `firstColHasZero`. This must happen last, since the first row/column are still needed as markers through step 3. 

## Complexity

| Time | Space |
|---|---|
| `O(m * n)`| `O(1)` |

## Notes
- The elegance of this solution is optimizing space complexity by using the first row and column both as original data and as marker/flag storage. 
- A more naive solution might involve mutating a copy of the original matrix, which takes `O(m * n)` space, or using two arrays as the row/column markers, which takes `O(m + n)` space.
