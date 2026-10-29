<!--
number: 0138
title: Copy List with Random Pointer
pattern: linked-list
difficulty: Medium
languages: Java
slug: copy-list-with-random-pointer
last_reviewed: 2026-10-28
-->
# Copy List with Random Pointer
[Problem Description](https://leetcode.com/problems/copy-list-with-random-pointer/description/)

Summary: Given the `head` of a linked list where each node has a `next` pointer and a `random` pointer (which may point to any node in the list or be `null`), return a deep copy of the list. The copy must consist of entirely new nodes, and none of its pointers may point to nodes in the original list.

## Algorithm
Two passes with a hashmap from each original node to its copy.

The difficulty is that `random` can point forward to a node that hasn't been copied yet. Creating every copy first, before linking anything, removes that ordering problem.

1. **Pass 1:** walk the list and, for each original node, store `copies.put(curr, new Node(curr.val))`. The copies are not linked yet.
2. **Pass 2:** walk the list again and, for each original node `curr`, wire its copy:
   - `copy.next = copies.get(curr.next)`
   - `copy.random = copies.get(curr.random)`
3. Return `copies.get(head)`.

Every pointer in the copy comes from the map, whose values are only new nodes, so the result is a true deep copy.

## Complexity

| Time | Space |
|---|---|
| $O(n)$ | $O(n)$ |

## Notes
- [Neetcode Solution](https://www.youtube.com/watch?v=5Y2EiZST97Y)
- **`null` handling is free:** Java's `HashMap` allows a `null` key, and `copies.get(null)` returns `null`. This covers the empty list, the tail's `next`, and `null` random pointers without special cases. This does not hold for every map: `TreeMap.get(null)` throws a `NullPointerException`.
- **Space:** the output nodes are required, but the map is $O(n)$ auxiliary space on top of them.
