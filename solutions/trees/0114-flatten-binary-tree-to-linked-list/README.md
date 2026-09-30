<!--
number: 0114
title: Flatten Binary Tree to Linked List
pattern: trees
difficulty: Medium
languages: Java
slug: flatten-binary-tree-to-linked-list
last_reviewed: 2026-09-29
-->
# Flatten Binary Tree to Linked List
[Problem Description](https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/)

Summary: Given the `root` of a binary tree, flatten it in place into a "linked list" that follows pre-order traversal (node, left, right): each node's `right` pointer points to the next node in pre-order, and every `left` pointer is `null`.

## Algorithm
Iterative splicing with $O(1)$ extra space. A pointer `curr` walks down the tree, starting at the root. At each node, if `curr` has a left child, that left subtree has to be placed between `curr` and its old right subtree:

1. Find the **rightmost** node of `curr.left` by following `.right` pointers as far as possible.
2. Attach the old right subtree there: `rightmost.right = curr.right`.
3. Move the left subtree to the right: `curr.right = curr.left`.
4. Clear the left pointer: `curr.left = null`.

Then move on with `curr = curr.right`. Step 2 comes before step 3, so the old right subtree is saved before `curr.right` is overwritten.

## Complexity

| Time | Space |
|---|---|
| $O(n)$ | $O(1)$ |

The outer loop visits each node once. The inner loop that finds the rightmost node walks over each node at most once across the whole run: a node is only ever on the right edge of one left subtree being searched, and after that splice it's part of the finished chain. Only two pointers are used.

## Notes
- **Edge Case:** the rightmost node isn't always the last node in pre-order. If it has a left child, its left subtree comes after it in pre-order. That's fine: attaching the old right subtree to it puts that subtree *somewhere after* it, and when `curr` later reaches that node, its own left subtree gets spliced in ahead of whatever is attached to its right. Every splice follows pre-order's rule (node, then left, then right), so the final order comes out correct.
