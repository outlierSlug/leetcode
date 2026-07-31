<!--
number: 0226
title: Invert Binary Tree
pattern: trees
difficulty: Easy
languages: Java
slug: invert-binary-tree
last_reviewed: 2026-07-27
-->
# Invert Binary Tree
[Problem Description](https://leetcode.com/problems/invert-binary-tree/description/)

Summary: Given the `root` of a binary tree, invert the tree and return its `root`.

## Algorithm
We will recurisvely invert the left and right subtrees of `root`, then swap the left and right subtree nodes themselves.

## Complexity

| Time | Space |
|---|---|
| `O(n)` | `O(n)` |

The space complexity is from the call stack, which is at worst `O(n)` in the case of a skewed tree, and is `O(log n)` if the tree is balanced.

## Notes
Bottom-up recursion is imperative to make sure each subtree is fully inverted before swapping the nodes at the parent level.