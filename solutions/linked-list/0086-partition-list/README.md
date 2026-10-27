<!--
number: 0086
title: Partition List
pattern: linked-list
difficulty: Medium
languages: Java
slug: partition-list
last_reviewed: 2026-10-26
-->
# Partition List
[Problem Description](https://leetcode.com/problems/partition-list/description/)

Summary: Given the `head` of a linked list and a value `x`, partition it so that all nodes with values less than `x` come before nodes with values greater than or equal to `x`. The original relative order of the nodes within each partition must be preserved.

## Algorithm
Build two separate lists with dummy heads, then join them.

1. Create two dummy nodes, `beforeDummy` for values `< x` and `afterDummy` for values `>= x`, each with a tail pointer (`before` and `after`).
2. Walk the original list once. Append each node to the tail of `before` if its value is `< x`, otherwise to the tail of `after`, and advance that tail.
3. Join the lists: `before.next = afterDummy.next`.
4. Terminate the list: `after.next = null`.
5. Return `beforeDummy.next`.

Nodes are appended in the order they are encountered, so the relative order within each partition is preserved.

## Complexity

| Time | Space |
|---|---|
| $O(n)$ | $O(1)$ |

## Notes
- **Cycle breaking:** the last node in the `after` list still holds its original `next` pointer, which may point to a node now in the `before` list. Without `after.next = null`, the result contains a cycle.
- **Dummies remove edge cases:** if every node is `< x`, the `after` list is empty and `before.next` gets `null`. If every node is `>= x`, `beforeDummy.next` becomes the start of the `after` list. Neither case needs special handling.
