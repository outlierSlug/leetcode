<!--
number: 0019
title: Remove Nth Node From End of List
pattern: linked-list
difficulty: Medium
languages: Java
slug: remove-nth-node-from-end-of-list
last_reviewed: 2026-10-22
-->
# Remove Nth Node From End of List
[Problem Description](https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/)

Summary: Given the `head` of a linked list, remove the `n`th node from the end of the list and return its head.

## Algorithm
One-pass two pointers with a fixed gap.

To delete a node, we need the node **before** it so we can set `slow.next = slow.next.next`. The challenge is locating "`n`th from the end" without first computing the length.

1. Create a `dummy` node pointing to `head`, and start both `slow` and `fast` at `dummy`. The dummy guarantees a node before the target even when the target is the head.
2. Advance `fast` by `n` steps to open a gap of `n` between the pointers.
3. Move both pointers one step at a time until `fast` is on the **last node** (`fast.next == null`). Since the gap is fixed, `slow` is now `n` nodes behind the last node, which is exactly the node before the target.
4. Unlink the target with `slow.next = slow.next.next`.
5. Return `dummy.next`, which handles the case where the original head was removed.

## Complexity
Let `L` be the length of the list.

| Time | Space |
|---|---|
| $O(L)$ | $O(1)$ |

## Notes

