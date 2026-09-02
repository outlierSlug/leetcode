<!--
number: 0289
title: Game of Life
pattern: matrix
difficulty: Medium
languages: Java
slug: game-of-life
last_reviewed: 2026-09-01
-->
# Game of Life
[Problem Description](https://leetcode.com/problems/game-of-life/description/)

Summary: Given an `m x n` board of live/dead cells, compute the next state of every cell simultaneously per Conway's rules, in-place, using `O(1)` extra space.

## Algorithm
All cells must transition based on their *original* board state, but overwriting cells in-place risks corrupting neighbor counts for other cells. Thus, we will solve this by using an encoding system to track the state transition of each cell:

- `0 -> 0` encoded as `0` (decodes to `0`)
- `1 -> 0` encoded as `1` (decodes to `0`)
- `0 -> 1` encoded as `2` (decodes to `1`)
- `1 -> 1` encoded as `3` (decodes to `1`)

Reading any cell's *original* state is given by `board[row][col] % 2`, since `0%2=0, 1%2=1, 2%2=0, 3%2=1`.

We will perform two passes through the entire board:
1. In the first pass, for each cell, count its live neighbors (8-directional, bounds-checked), then apply Conway's rules and encode its resultant transition.
2. In the second pass, simply decode every cell in-place.
## Complexity

| Time | Space |
|---|---|
| `O(m * n)`| `O(1)` |

## Notes
- [Neetcode Solution](https://www.youtube.com/watch?v=fei4bJQdBUQ)
- `dr` and `dc` in the `countNeighbors` helper method stand for "delta row" and "delta column" and is an efficient way of checking all 8 neighbor slots (excluding `(0, 0)` which is the current cell).
