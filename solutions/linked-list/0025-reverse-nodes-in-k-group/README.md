<!--
number: 0025
title: Reverse Nodes in k-Group
pattern: linked-list
difficulty: Hard
languages: Java
slug: reverse-nodes-in-k-group
last_reviewed: 2026-10-28
-->
# Reverse Nodes in k-Group
[Problem Description](https://leetcode.com/problems/reverse-nodes-in-k-group/description/)

Summary: Given the `head` of a linked list, reverse the nodes of the list `k` at a time and return the modified list. If the number of nodes remaining at the end is less than `k`, they stay in their original order. Only the links between nodes may change, not the node values.

## Algorithm
Repeat the walk-reverse-reconnect step from [Reverse Linked List II (92)](../0092-reverse-linked-list-ii/) once per group, checking that a full group exists before each reversal.

1. Create a `dummy` pointing to `head`, and set `before = dummy`, the node just before the current group.
2. Loop:
   - **Check for a full group:** walk a `probe` pointer up to `k` steps from `before`. If it reaches `null`, fewer than `k` nodes remain, so stop. The leftover nodes are already linked correctly.
   - **Save `first = before.next`.** After reversal, it becomes the group's tail.
   - **Reverse exactly `k` nodes** starting at `first`, using the standard reversal loop. Afterwards, `prev` is the new front of the group, and `curr` is the first node of the next group.
   - **Reconnect:** `first.next = curr` and `before.next = prev`.
   - **Advance:** `before = first`, since the old first node is now the node just before the next group.
3. Return `dummy.next`.

## Complexity

| Time | Space |
|---|---|
| $O(n)$ | $O(1)$ |

## Notes
- **Each node is visited at most twice:** once by the probe and once by the reversal, so the total work is linear.
- **Breaking out of nested loops:** a `break` inside the probe's `for` loop only exits that loop. Checking `probe == null` after it is what exits the outer loop. Putting `probe != null` in the `for` condition is an equivalent alternative.
- **Why the probe step count works:** `probe` starts on `before`, so after `k` steps it sits on the group's last node. A full group exists exactly when that node is non-null.
- **No special cases:** `k = 1` reverses single nodes, leaving the list unchanged. `k = n` reverses the whole list once. The dummy handles the head changing after the first group.
