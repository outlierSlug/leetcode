<!--
number: 0103
title: Binary Tree Zigzag Level Order Traversal
pattern: trees
difficulty: Medium
languages: Java
slug: binary-tree-zigzag-level-order-traversal
last_reviewed: 2026-09-29
-->
# Binary Tree Zigzag Level Order Traversal
[Problem Description](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/)

Summary: Given the `root` of a binary tree, return its node values level by level, alternating direction: left to right on the first level, right to left on the next, and so on.

## Algorithm
BFS, functionally similar to [Level Order Traversal](../0102-binary-tree-level-order-traversal/), with every other level's list reversed.

Read `int size = queue.size()` before processing a level, take out exactly `size` nodes, add each value to the level's list, and add each node's non-null children to the queue in the usual left-then-right order. A `depth` counter tracks the current level. After a level is done, if `depth % 2 == 1`, the list is reversed with `Collections.reverse` before being added to the result.

The queue itself is never changed, so the traversal is identical to Level Order. Only how each level is recorded differs.

An empty tree returns an empty list before the loop starts.

## Complexity

| Time | Space |
|---|---|
| $O(n)$ | $O(w)$ |

Each node goes into and out of the queue exactly once. Reversing a level costs $O(\text{size})$, and all the levels together add up to $n$ nodes, so the reversals add only $O(n)$ in total. Space depends on the widest level `w`: $O(n)$ in the worst case.

## Notes
- **BFS template:** [Level Order](../0102-binary-tree-level-order-traversal/), [Right Side View](../0199-binary-tree-right-side-view/), [Average of Levels](../0637-average-of-levels-in-binary-tree/), and Zigzag all use the same loop. The only thing that changes is what gets recorded for each level: the full list, the last node, the average, or the list in alternating directions.
