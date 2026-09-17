<!--
number: 0079
title: Word Search
pattern: backtracking
difficulty: Medium
languages: Java
slug: word-search
last_reviewed: 2026-09-16
-->
# Word Search
[Problem Description](https://leetcode.com/problems/word-search/description/)

Summary: Given an `m x n` grid of characters `board` and a string `word`, return `true` if word exists in the grid. The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

## Algorithm
We will use brute-force backtracking, starting the search from every cell in the grid. From the start cell, recurisvely check whether that cell matches the character at the current index in `word`. If so, mark the cell as visited (restore it on un-choose) and continue recursing.

**Base Case**: `index == word.length()` means all characters of `word` have been found in order. Return `true`.

**Recursive Case**: Ensure we are at a valid grid cell and that the cell we are on is the right character in `word`. Check every cardinal direction from the current cell and recurse.

## Complexity

Let `L = word.length()`.

| Time | Space |
|---|---|
| `O(m * n * 3^L)`| `O(L)` |

## Notes
- Branching factor is 3, not 4, for all but the very first step of a path: after moving into a cell, one neighboring direction is always the cell just came from, which is already marked visited and can't be revisited, leaving at most 3 viable directions at each subsequent step.
