<!--
number: 0909
title: Snakes and Ladders
pattern: graphs
difficulty: Medium
languages: Java
slug: snakes-and-ladders
last_reviewed: 2026-09-21
-->
# Snakes and Ladders
[Problem Description](https://leetcode.com/problems/snakes-and-ladders/description/)

Summary: Given an `n x n` board numbered 1 to `n^2` in a boustrophedon (alternating direction) pattern, with some squares holding a snake or ladder to another square, return the minimum number of dice rolls to reach square `n²` from square 1, or `-1` if impossible.

## Algorithm
Since the problem asks for the minimum number of moves, this is a natural BFS problem, with each roll as a step to the next "layer".

The key part of the algorithm is converting the number of a square to its actual `(row, col)` index in `board`, since the board is given as a standard 2D array (`board[0]` = top row) while squares are numbered starting bottom-left in a snaking pattern:

```java
private int getSquareValue(int[][] board, int square, int n) {
    int r = (square - 1) / n;              // row from bottom, 0-indexed
    int c = (square - 1) % n;              // base column index
    if (r % 2 == 1) {                       // odd row from bottom -> right-to-left
        c = n - 1 - c;
    }
    int val = board[n - 1 - r][c];          // convert "from bottom" to actual grid row
    return val == -1 ? square : val;        // -1 means no snake/ladder; otherwise it's the destination
}
```

We run BFS: from the current square, try all die rolls `current + 1` through `min(current + 6, target)`, resolve each through `getSquareValue` (following a snake/ladder if present), and enqueue any unvisited destination. Track moves via the level-by-level pattern (snapshot `queue.size()` before each level's inner loop). Check `current == target` at dequeue time.

## Complexity

| Time | Space |
|---|---|
| `O(n^2)`| `O(n^2)` |

## Notes
- Each square is enqueued/dequeued at most once; each dequeue does at most 6 constant-time die-roll checks, so total work is proportional to the total number of squares.
- [NeetCode Solution](https://www.youtube.com/watch?v=6lH4nO3JfLk)
