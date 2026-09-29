<!--
number: 0637
title: Average of Levels in Binary Tree
pattern: trees
difficulty: Medium
languages: Java
slug: average-of-levels-in-binary-tree
last_reviewed: 2026-09-29
-->
# Average of Levels in Binary Tree
[Problem Description](https://leetcode.com/problems/average-of-levels-in-binary-tree/description/)

Summary: Given the `root` of a binary tree, return the average value of the nodes on each level as a `List<Double>`.

## Algorithm
BFS level-by-level, functionally similar to [Level Order Traversal](../0102-binary-tree-level-order-traversal/) and taking the average of the nodes on each level.

Read `int size = queue.size()` before processing a level, take out exactly `size` nodes, and add each node's non-null children to the queue. While taking nodes out, add each value to a `long levelSum`. Once the level is done, its average is `(double) levelSum / size`, which is added to the result.

An empty tree returns an empty list before the loop starts.

## Complexity

| Time | Space |
|---|---|
| $O(n)$ | $O(w)$ |

Each node goes into and out of the queue exactly once. Space depends on the widest level `w`: $O(n)$ in the worst case, since the last level of a complete tree has about $n/2$ nodes.


## Notes
- **Overflow:** node values can be as large as `Integer.MAX_VALUE` (about $2.1 \times 10^9$), and a level can hold up to $10^4$ nodes, so a level's sum can reach about $2 \times 10^{13}$. Two maximum values on the same level already overflow an `int`. A `long` goes up to about $9.2 \times 10^{18}$, so it holds any level's sum exactly.
- **Where the cast goes:** `(double) levelSum / size` converts the sum *before* dividing, so the division is done in floating point (`29 / 2` gives `14.5`). Writing `(double) (levelSum / size)` divides as whole numbers first and then converts, giving `14.0`. Leaving out the cast entirely also divides as whole numbers.
- **Summing into a `double`:** also works here, since `double` stores whole numbers exactly up to $2^{53} \approx 9 \times 10^{15}$, which covers this range. `long` is the cleaner choice because the sum stays exact until the single division at the end.
