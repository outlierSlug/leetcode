<!--
number: 0092
title: Reverse Linked List II
pattern: linked-list
difficulty: Medium
languages: Java
slug: reverse-linked-list-ii
last_reviewed: 2026-10-28
-->
# Reverse Linked List II
[Problem Description](https://leetcode.com/problems/reverse-linked-list-ii/description/)

Summary: Given the `head` of a singly linked list and two integers `left <= right`, reverse the nodes from position `left` to position `right` (1-indexed) and return the list.

## Algorithm
One pass: walk to the sublist, reverse it in place with the standard reversal loop, then reconnect both ends.

Reversing a sublist in the middle of a list requires four boundary nodes:

    dummy → 1 → [2 → 3 → 4] → 5
            ^    ^       ^    ^
        before  first  last  after

1. Create a `dummy` pointing to `head`, since the head changes when `left = 1`.
2. Walk `left - 1` steps from `dummy` to reach `before`, the node just before the sublist.
3. Save `first = before.next`. Reversal flips pointers without moving nodes, so `first` ends up as the sublist's tail.
4. Run the [206](../0206-reverse-linked-list/) reversal loop (`prev`, `curr`, `next`) exactly `right - left + 1` times starting at `first`. Afterwards:
   - `prev` is the old `last`, now the front of the reversed sublist.
   - `curr` is `after`, the first node past the sublist.
5. Reconnect: `first.next = curr` attaches the new tail to the rest of the list, and `before.next = prev` attaches the new front.
6. Return `dummy.next`.

## Complexity

| Time | Space |
|---|---|
| $O(n)$ | $O(1)$ |

## Notes
- **Why save `first`:** after the reversal, `before.next` still points to the old first node, so it could be used instead. But then the reconnection order matters: `before.next.next = curr` must run before `before.next = prev`. Saving `first` explicitly removes that trap.
- **`prev` can start as `null`:** the first reversed node's `next` is temporarily set to `null`, but `first.next = curr` overwrites it during reconnection.
- **Edge cases with no special handling:** `left = right` reverses a single node and restores it. `left = 1` leaves `before` on the dummy, so the head updates through `dummy.next`. `right = n` leaves `curr` as `null`, so `first` becomes the tail.