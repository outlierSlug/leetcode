<!--
number: 0530
title: Minimum Absolute Difference in BST
pattern: trees
difficulty: Easy
languages: Java
slug: minimum-absolute-difference-in-bst
last_reviewed: 2026-09-29
-->
# Minimum Absolute Difference in BST
[Problem Description](https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/)

Summary: Given the `root` of a binary search tree, return the smallest difference between the values of any two different nodes.

## Algorithm
An **in-order** traversal (left, node, right) of a BST visits values in ascending order. In a sorted sequence, the smallest difference is always between two *neighboring* values, so each node only needs to be compared with the node visited just before it. That replaces checking every pair with a single pass.

Two instance variables hold the state across recursive calls:
- `prev`: the last node visited, or `null` if none yet
- `minDiff`: the smallest difference found so far, starting at `Integer.MAX_VALUE`

The main method resets both before starting the traversal. At each node, if `prev` isn't `null`, `minDiff` is updated with `node.val - prev.val`, and then the current node becomes `prev`.


## Complexity

| Time | Space |
|---|---|
| $O(n)$ | $O(h)$ |

Each node is visited once. Space comes from the recursion stack, which grows with the tree's height `h`: $O(\log n)$ for a balanced tree, and $O(n)$ for a skewed one.

## Notes
- **No `Math.abs` needed:** values arrive in ascending order, so `node.val - prev.val` is never negative.
- **`TreeNode prev` instead of an `int`:** `null` clearly means "no previous node," so the smallest node's comparison is skipped without a sentinel value that could collide with a real value.
- **Regular binary tree (not a BST):** in-order no longer gives sorted values. Collect all values, sort them, and scan neighboring pairs, for $O(n \log n)$ time and $O(n)$ space. That's generally the best possible, because a faster solution would also detect duplicate values (a gap of 0), which requires $O(n \log n)$ comparisons. With a small known value range, marking values in a `boolean[]` of that size gives $O(n + \text{range})$.
- **Same problem:** LeetCode 783, Minimum Distance Between BST Nodes, is identical to this problem.
