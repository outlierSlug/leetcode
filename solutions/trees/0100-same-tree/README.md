<!--
number: 0100
title: Same Tree
pattern: trees
difficulty: Easy
languages: Java
slug: same-tree
last_reviewed: 2026-07-25
-->
# Same Tree
[Problem Description](https://leetcode.com/problems/same-tree/description/)

Summary: Given the roots of two binary trees `p` and `q`, write a function to check if they are the same or not.

## Algorithm
- Base Case: If both roots are null, the trees are identical. If one is null and the other is not, or the values of then nodes are not equal, they are not identical.
```java
if (p == null && q == null) return true;
if (p == null || q == null || p.val != q.val) return false;
```
- Recursive Case: Split and recurse down the left and right subtrees of both `p` and `q` and take the logical AND of the two booleans.
```java
return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
```

## Complexity

| Time | Space |
|---|---|
| `O(min(n, m))` | `O(h)` |

Note that `h` is the height of the shallower tree.

## Notes
In the worst case (identical trees or skewed matching trees), both time and space complexity bottom out at `O(n)`.