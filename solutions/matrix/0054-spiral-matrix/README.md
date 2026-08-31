<!--
number: 0054
title: Spiral Matrix
pattern: matrix
difficulty: Medium
languages: Java
slug: spiral-matrix
last_reviewed: 2026-08-30
-->
# Spiral Matrix
[Problem Description](https://leetcode.com/problems/spiral-matrix/description/)

Summary: Given an `m x n` matrix, return all its elements in spiral order.

## Algorithm
We will maintain four boundaries called `top`, `bottom`, `left`, and `right`, which mark the edges of the current univisited ring of the matrix. Each iteration traverses the spiral and shrinks the corresponding boundary inwards.

1. Top row, left to right; then `top++`, shrinking the top boundary index down.
2. Right column, top to bottom; then `right--`, shrinking the right boundary index inwards.
3. Bottom row, right to left **only if `top <= bottom` still holds**.
4. Left column, bottom to top **only if `left <= right` still holds**.

Repeat while `top <= bottom && left <= right`.

The guards on steps 3 and 4 are necessary because `top`/`right` have already shrunk earlier in the same iteration. When only a single row or single column remains in the current ring, the top-row or right-column traversal fully consumes it. Re-running the bottom-row or left-column traversal without the guard would re-visit those same elements and produce duplicates.

## Complexity

| Time | Space |
|---|---|
| `O(m * n)`| `O(1)` |

Auxiliary space usage is constant. The `result` list is of size `O(m * n)`.

## Notes
[Neetcode Solution](https://www.youtube.com/watch?v=BJnMZNwUk1M)
