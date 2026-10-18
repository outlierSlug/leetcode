<!--
number: 0105
title: Construct Binary Tree from Preorder and Inorder Traversal
pattern: trees
difficulty: Medium
languages: Java
slug: construct-binary-tree-from-preorder-and-inorder-traversal
last_reviewed: 2026-10-17
-->
# Construct Binary Tree from Preorder and Inorder Traversal
[Problem Description](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/)

Summary: Given two integer arrays `preorder` and `inorder`, the preorder and inorder traversals of the same binary tree with unique values, construct and return the tree.

## Algorithm
Recursive divide and conquer over index ranges.

The two traversals give complementary information:
- **Preorder** (root, left, right): the first element of any subtree's range is that subtree's root.
- **Inorder** (left, root, right): once the root is located, everything to its left belongs to the left subtree and everything to its right belongs to the right subtree.

**Setup:**
- Build a hashmap from each value to its index in `inorder`. Values are unique, so every root lookup is $O(1)$ instead of a linear scan.

**Recursive helper** `construct(preStart, inLeft, inRight)` builds the subtree whose root is `preorder[preStart]` and whose nodes occupy `inorder[inLeft..inRight]`:
- **Base case:** if `inRight - inLeft < 0`, the range is empty, so return `null`.
- Create the root from `preorder[preStart]`.
- Look up `rootIndex` in the map, and compute `leftSize = rootIndex - inLeft`.
- **Left subtree:** its preorder segment starts right after the root at `preStart + 1`, and its inorder range is `[inLeft, rootIndex - 1]`.
- **Right subtree:** its preorder segment starts after the root and all `leftSize` left-subtree nodes, at `preStart + 1 + leftSize`. Its inorder range is `[rootIndex + 1, inRight]`.
- Return the root.

The key insight is that inorder supplies the **sizes** of the subtrees, and those sizes are what let you locate each subtree's segment in preorder.

## Complexity

| Time | Space |
|---|---|
| $O(n)$ | $O(n)$ |

## Notes
- Without the hashmap, finding the root in `inorder` takes a linear scan per call, which degrades to $O(n^2)$ on a skewed tree.
- The base case uses the inorder range only. The preorder range never needs an explicit end, because its length always equals the inorder range's length.
- The unique-values guarantee is essential. With duplicates, the root's position in `inorder` would be ambiguous and the tree might not be uniquely determined.
