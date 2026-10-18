<!--
number: 0106
title: Construct Binary Tree from Inorder and Postorder Traversal
pattern: trees
difficulty: Medium
languages: Java
slug: construct-binary-tree-from-inorder-and-postorder-traversal
last_reviewed: 2026-10-17
-->
# Construct Binary Tree from Inorder and Postorder Traversal
[Problem Description](https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/)

Summary: Given two integer arrays `inorder` and `postorder`, the inorder and postorder traversals of the same binary tree with unique values, construct and return the tree.


## Algorithm
Recursive divide and conquer over index ranges. This is the mirror of 105.

The two traversals give complementary information:
- **Postorder** (left, right, root): the last element of any subtree's segment is that subtree's root. Reading backwards from the root, the segment is the root, then the right subtree, then the left subtree.
- **Inorder** (left, root, right): once the root is located, everything to its left belongs to the left subtree and everything to its right belongs to the right subtree.

**Setup:**
- Build a hashmap from each value to its index in `inorder`. Values are unique, so every root lookup is $O(1)$.

**Recursive helper** `construct(postEnd, inLeft, inRight)` builds the subtree whose root is `postorder[postEnd]` and whose nodes occupy `inorder[inLeft..inRight]`:
- **Base case:** if `inRight - inLeft < 0`, the range is empty, so return `null`.
- Create the root from `postorder[postEnd]`.
- Look up `rootIndex` in the map, and compute `rightSize = inRight - rootIndex`.
- **Right subtree:** its postorder segment ends immediately before the root, at `postEnd - 1`. Its inorder range is `[rootIndex + 1, inRight]`.
- **Left subtree:** its postorder segment ends before the root and all `rightSize` right-subtree nodes, at `postEnd - 1 - rightSize`. Its inorder range is `[inLeft, rootIndex - 1]`.
- Return the root.

As in 105, inorder supplies the subtree **sizes**, and those sizes locate each subtree's segment in the other traversal. Here the offsets count backwards from the end of the segment instead of forwards from the start.

## Complexity

| Time | Space |
|---|---|
| $O(n)$ | $O(n)$ |

## Notes
- With explicit `postEnd` indices, the two recursive calls can run in either order, since each call computes its own position.
- Without the hashmap, finding the root in `inorder` takes a linear scan per call, which degrades to $O(n^2)$ on a skewed tree.
- Unique values are essential. With duplicates, the root's position in `inorder` would be ambiguous.
