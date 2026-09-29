<!--
number: 0098
title: Validate Binary Search Tree
pattern: trees
difficulty: Medium
languages: Java
slug: validate-binary-search-tree
last_reviewed: 2026-09-29
-->
# Validate Binary Search Tree
[Problem Description](https://leetcode.com/problems/validate-binary-search-tree/description/)

Summary: Given the `root` of a binary tree, return `true` if it is a valid binary search tree: for every node, all values in its left subtree are strictly less than it, and all values in its right subtree are strictly greater.

## Algorithm
A binary tree is a valid BST exactly when its in-order traversal (left, node, right) produces values in **strictly increasing** order. So the check is an in-order traversal that compares each node with the one visited just before it.

A single instance field, `prev`, holds the last node visited in-order (`null` if none yet). It's reset at the start of the main method. The helper returns a `boolean`, so a violation found anywhere is passed straight back up and stops the search:

- **Null node:** return `true`. An empty subtree contains nothing that breaks the rule. This covers both an empty tree and the missing children below every leaf.
- **Left subtree:** if it's invalid, return `false`.
- **Current node:** if `prev` exists and `prev.val >= node.val`, the sequence isn't strictly increasing, so return `false`. Otherwise this node becomes `prev`.
- **Right subtree:** if invalid, will return `false`, otherwise will return `true`.

## Complexity

| Time | Space |
|---|---|
| $O(n)$ | $O(h)$ |

A valid tree is fully visited, and an invalid one stops at the first violation. Space comes from the recursion stack, which grows with the tree's height $h$.

## Notes
- The comparison uses `>=` so that equal values are rejected. Duplicates make a BST invalid under this problem's definition.
