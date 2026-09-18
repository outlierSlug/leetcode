<!--
number: 0130
title: Surrounded Regions
pattern: graphs
difficulty: Medium
languages: Java
slug: surrounded-regions
last_reviewed: 2026-09-18
-->
# Surrounded Regions
[Problem Description](https://leetcode.com/problems/surrounded-regions/description/)

Summary: Given an `m x n` board of `'X'` and `'O'`, capture (flip to `'X'`) every region of `'O'`s fully surrounded by `'X'`s. A region survives if it's connected to any `'O'` on the board's border.

## Algorithm
Rather than searching for regions to capture, we can find the regions that survive (any region that is connected to the border), since a border cell cannot be captured. We will check every border cell, and we will set any `'O'` cells part of a border region to a sentinel value `'#'`. Then, in a final pass of the board, we will set every remaining `'O'` to `'X'` (captured), and restore every `'#'` to `'O'` (safe).

The `markSafe` function runs DFS starting from every `O` on the border.

## Complexity

| Time | Space |
|---|---|
| `O(m * n)`| `O(m * n)` |

## Notes
-  The corner cells get visited twice by the two boundary loops (once as part of a row, once as part of a column). However, this is harmless, since the guard clause immediately rejects the second call (if it was originally an `'O'` on the border, it will have been marked with `'#'`).
