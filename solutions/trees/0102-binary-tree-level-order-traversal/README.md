<!--
number: 0102
title: Binary Tree Level Order Traversal
pattern: trees
difficulty: Medium
languages: Java
slug: binary-tree-level-order-traversal
last_reviewed: 2026-09-29
-->
# Binary Tree Level Order Traversal
[Problem Description](https://leetcode.com/problems/binary-tree-level-order-traversal/description/)

Summary: Given the `root` of a binary tree, return its node values level by level, from left to right.

## Algorithm
BFS with a queue, processing one full level per round of the outer loop.

The key step is reading `int size = queue.size()` **before** taking any nodes out. At the start of each round, the queue holds exactly the nodes on the current level. The inner loop then takes out exactly `size` nodes, adds each value to the current level's list, and adds each node's non-null children to the queue. Those children belong to the next level: they sit behind the current level's nodes and aren't touched until the next round. Once the inner loop finishes, the level's list is added to the result.

An empty tree returns an empty list before the loop starts.

## Complexity

| Time | Space |
|---|---|
| $O(n)$ | $O(w)$ |

Each node goes into and out of the queue exactly once. Space depends on the widest level `w`, since that's the most nodes the queue holds at once. In a complete tree the last level has about $\frac{n}{2}$ nodes, so the worst case is $O(n)$.

## Notes
- **`ArrayDeque` vs `LinkedList`:** both work as the queue. `ArrayDeque` is faster in practice (elements are stored next to each other and no object is created per add), but it throws on `null` elements, so children must be checked before `offer`. `LinkedList` accepts `null`, but adding `null` children and skipping them later wastes queue operations.
- **BFS vs DFS space:** BFS space grows with the tree's *width*, DFS space with its *height*. Tall, narrow trees favor BFS, and wide, bushy trees favor DFS.
- **DFS alternative:** pass `depth` down the recursion. When `depth == result.size()`, this is the first node seen at that depth, so add a new empty list. Then add the value to `result.get(depth)`. Visiting left before right keeps each level in left-to-right order. This uses $O(h)$ space instead of $O(w)$.
