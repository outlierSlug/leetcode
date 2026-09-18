<!--
number: 0200
title: Number of Islands
pattern: graphs
difficulty: Medium
languages: Java
slug: number-of-islands
last_reviewed: 2026-09-18
-->
# Number of Islands
[Problem Description](https://leetcode.com/problems/number-of-islands/description/)

Summary: Given an `m x n` 2D binary grid `grid` which represents a map of `'1'`s (land) and `'0'`s (water), return the number of islands. 

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

## Algorithm
Scan every cell in the grid. If it is an univisited `1`, increment the `count` of islands and call `dfs` from this cell to mark every `1` connected to it. 

The `dfs` function marks cells visited in-place by overwriting `'1'` with `'0'`. No separate data structure is needed and the grid does not need to be preserved.

## Complexity

| Time | Space |
|---|---|
| `O(m * n)`| `O(m * n)` |

## Notes
- Diagonal adjacency does not count, neighbors are only considered in the four cardinal directions (up/down, left/right).
- Each cell is processed by `dfs` at most once total across the whole algorithm: once marked `'0'`, any future call on that cell fails the guard clause immediately and returns, so total work is bounded by the total cell count.
-  Space is worst-case `O(m * n)`. Recursion depth is bounded by the size of the largest connected island, which could span the entire grid in a single snaking path.