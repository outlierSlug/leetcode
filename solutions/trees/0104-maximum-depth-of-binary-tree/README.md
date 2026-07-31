<!--
number: 0104
title: Maximum Depth of Binary Tree
pattern: trees
difficulty: Easy
languages: Java
slug: maximum-depth-of-binary-tree
last_reviewed: 2026-07-25
-->
# Maximum Depth of Binary Tree
[Problem Description](https://leetcode.com/problems/maximum-depth-of-binary-tree/description/)

Summary: Given the `root` of a binary tree, return its *maximum depth*.

## Algorithm
This uses the canonical recursive algorithm for trees:
- Base Case: If the node doesn't exist, the depth is 0.
```java
if (root == null) return 0;
```
- Recursive Case: Split and recurse down the left and right subtrees. Return `1` for the current layer plus the max of the left or right subtree.
```java
int left = maxDepth(root.left);
int right = maxDepth(root.right);
return 1 + Math.max(left, right);
```

## Complexity

 Time | Space |
|---|---|
| `O(n)` | `O(h)` |

Every node is visited once, giving an `O(n)` runtime.

`h` is the tree height, giving an `O(h)` space complexity from the call stack.

## Notes
For a balanced tree, the space complexity is `O(log n)`, and in the worst case, if the tree is degenerate, it is `O(n)`.