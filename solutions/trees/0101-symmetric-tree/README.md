<!--
number: 0101
title: Symmetric Tree
pattern: trees
difficulty: Easy
languages: Java
slug: symmetric-tree
last_reviewed: 2026-09-26
-->
# Symmetric Tree
[Problem Description](https://leetcode.com/problems/symmetric-tree/description/)

Summary: Given the `root` of a binary tree, return `true` if the tree is a mirror image of itself (symmetric around its center).

## Algorithm
A tree is symmetric exactly when its left and right subtrees are mirror images of each other. A helper `isMirror(a, b)` checks this recursively. It's a variation of [Same Tree](../0100-same-tree/), except the children are compared crosswise instead of side by side.

**Base cases:** if both nodes are `null`, the two subtrees end together, so return `true`. If only one is `null`, the shapes differ, so return `false`.

**Recursive case:** two subtrees are mirrors if all three of these hold:
- `a.val == b.val`
- `a.left` mirrors `b.right` (the outer pair)
- `a.right` mirrors `b.left` (the inner pair)

The value check comes first, so `&&` short-circuits and skips the recursion as soon as two roots differ.

## Complexity

| Time | Space |
|---|---|
| $O(n)$ | $O(h)$ |

`h` is the height of the tree, which is $O(\log n)$ for a balanced tree, and $O(n)$ in the worst case.

## Notes
- Note that `root` is guaranteed to be non-null, otherwise we could add an `if (root == null) return true` check early.
