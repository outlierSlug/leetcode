<!--
number: 0199
title: Binary Tree Right Side View
pattern: trees
difficulty: Medium
languages: Java
slug: binary-tree-right-side-view
last_reviewed: 2026-09-29
-->
# Binary Tree Right Side View
[Problem Description](https://leetcode.com/problems/binary-tree-right-side-view/description/)

Summary: Given the `root` of a binary tree, imagine standing to its right. Return the values of the nodes you can see, from top to bottom.

## Algorithm
The visible node on each level is that level's **rightmost** node, so this is [Level Order Traversal](../0102-binary-tree-level-order-traversal/) with one change: record only the last node taken out in each level.

The BFS loop is standard: Read `int size = queue.size()` before processing a level, take out exactly `size` nodes, and add each node's non-null children to the queue. When `i == size - 1`, the current node is the rightmost on its level, so its value is added to the result. The output is a flat `List<Integer>`, one value per level.

An empty tree returns an empty list before the loop starts.

## Complexity

| Time | Space |
|---|---|
| $O(n)$ | $O(w)$ |

Each node goes into and out of the queue exactly once. Space depends on the widest level `w`: $O(n)$ in the worst case, since the last level of a complete tree has about $\frac{n}{2}$ nodes.

## Notes
- **DFS alternative:** pass `depth` down the recursion and visit the **right child before the left**. Record a node only when `depth == result.size()`, which means it's the first node reached at that depth. Since the search always tries the right side first, the first node at each depth is the rightmost. This uses $O(h)$ space instead of $O(w)$.
- **Left side view:** the same DFS visiting left before right gives the left side view. In the BFS version, record the node where `i == 0` instead of `i == size - 1`.
