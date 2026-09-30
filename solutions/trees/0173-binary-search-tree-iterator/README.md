<!--
number: 0173
title: Binary Search Tree Iterator
pattern: trees
difficulty: Medium
languages: Java
slug: binary-search-tree-iterator
last_reviewed: 2026-09-29
-->
# Binary Search Tree Iterator
[Problem Description](https://leetcode.com/problems/binary-search-tree-iterator/description/)

Summary: Design an iterator over a BST that returns its values in ascending order. `next()` returns the next smallest value, and `hasNext()` reports whether any values remain. Both should run in $O(1)$ average time using $O(h)$ memory.

## Algorithm
An in-order traversal visits a BST's values in sorted order, but here the *caller* controls the pace: each `next()` must return one value and then stop, and the following call must continue where the last one left off. A recursive traversal can't pause like that, so the iterator keeps an explicit stack of the nodes that are still waiting, which is exactly what the recursion's call stack would have held.

**`pushLeft(node)`:** pushes `node` and its left chain (its left child, that node's left child, and so on) onto the stack. The top is then the smallest value in `node`'s subtree.

**Invariant:** the top of the stack is always the next smallest value not yet returned. The nodes below it are ancestors waiting their turn.

- **Constructor:** `pushLeft(root)`, so the smallest value in the tree is on top.
- **`next()`:** pop the top node, call `pushLeft` on its right child, and return the popped node's value. After a node is returned, `pushLeft(node.right)` makes the smallest value in its right subtree the next one returned. The rest of that subtree gets pushed gradually by later calls, and only after it's used up does the next waiting ancestor reach the top.
- **`hasNext()`:** values remain exactly when the stack isn't empty.


## Complexity

| Operation | Time |
|---|---|
| Constructor | $O(h)$ |
| `next()` | $O(1)$ amortized, $O(h)$ worst case |
| `hasNext()` | $O(1)$ |

Space: $O(h)$. The stack only ever holds nodes along one path from the root. A single `next()` can push a long left chain, but over the whole iteration each node is pushed once and popped once, about $2n$ stack operations across $n$ calls, so each call averages $O(1)$.


## Notes
- **Empty iterator:** `stack.pop()` throws `NoSuchElementException` if `next()` is called with no values left. LeetCode never does this, and throwing that exception matches the rules of Java's `Iterator` interface.

