<!--
number: 0230
title: Kth Smallest Element in a BST
pattern: trees
difficulty: Medium
languages: Java
slug: kth-smallest-element-in-a-bst
last_reviewed: 2026-09-29
-->
# Kth Smallest Element in a BST
[Problem Description](https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/)

Summary: Given the `root` of a binary search tree and an integer `k`, return the `k`th smallest value in the tree (1-indexed).

## Algorithm
An in-order traversal (left, node, right) of a BST visits values in ascending order, so the `k`th node visited in-order holds the answer.

Two instance variables hold the state across recursive calls, and both are reset at the start of the main method:
- `count`: how many nodes have been visited in-order so far
- `result`: the answer, once found

At each node, `count` is incremented. When it reaches `k`, the node's value is recorded and the search stops.

**Stopping early** takes two checks, each using `count >= k`:
- **At the top of each call:** don't start searching a subtree once the answer is known.
- **After recursing into the left subtree:** if the answer was found somewhere inside it, don't count the current node or search the right subtree.

## Complexity

| Time | Space |
|---|---|
| $O(h + k)$ | $O(h)$ |

The search first walks down about $h$ nodes to reach the smallest value, then visits $k$ nodes in order before stopping. This beats $O(n)$ when $k$ is small. Space comes from the recursion stack, which grows with the tree's height $h$.


## Notes
- **`count >= k` vs `count == k`:** they're equivalent here. `count` increases by exactly 1 at a time, and every path checks it before incrementing, so it never passes `k`. `>=` is just a defensive habit.
- **Follow-up, frequent inserts and deletes:** re-running the traversal costs $O(h + k)$ per query. Storing each node's position in sorted order doesn't work either: inserting a new smallest value shifts every other node's position, which costs $O(n)$ per change. Instead, store each node's **subtree size**, which only changes along the path of an insert or delete. To find the `k`th smallest, let `leftSize` be the size of the current node's left subtree:
  - `k == leftSize + 1`: the current node is the answer.
  - `k <= leftSize`: go left with the same `k`.
  - otherwise: go right with `k - (leftSize + 1)`.

  Lookups, inserts, and deletes are all $O(h)$. This is called an **order-statistic tree**.
- **Relation to AVL trees:** a self-balancing BST (AVL or red-black) keeps $h = O(\log n)$, making every operation $O(\log n)$. AVL nodes already store `height = 1 + max(height(left), height(right))`, and subtree size is maintained the same way: `size = 1 + size(left) + size(right)`, recomputed along the insert or delete path and for the nodes involved in each rotation. Java's `TreeMap` is a red-black tree but doesn't store sizes, so it can't find the `k`th smallest in $O(\log n)$.
