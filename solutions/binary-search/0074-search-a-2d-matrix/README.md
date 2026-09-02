<!--
number: 0074
title: Search a 2D Matrix
pattern: binary-search
difficulty: Medium
languages: Java
slug: search-a-2d-matrix
last_reviewed: 2026-09-02
-->
# Search a 2D Matrix
[Problem Description](https://leetcode.com/problems/search-a-2d-matrix/description/)

Summary: Given an `m x n` matrix where each row is sorted left to right and the first element of each row exceeds the last element of the previous row, determine if `target` exists.

## Algorithm
Since the matrix is effectively a single sorted array split into rows of length `COLS`, we can perform binary search directly over the flattened index space `[0, ROWS*COLS - 1]`.

For a flattened index `mid`, recover its 2D coordinates via:
```java
int row = mid / COLS;
int col = mid % COLS;
```
This is the inverse of the flattening formula `flatIndex = row * COLS + col`. Dividing by `COLS` recovers which row `mid` falls in, and the remainder recovers the column within that row.

We compare `matrix[row][col]` to `target` and narrow `lo`/`hi` exactly as in vanilla binary search.

## Complexity

| Time | Space |
|---|---|
| `O(log(m*n))`| `O(1)` |

## Notes
[704. Binary Search](../0704-binary-search/)
