<!--
number: 0061
title: Rotate List
pattern: linked-list
difficulty: Medium
languages: Java
slug: rotate-list
last_reviewed: 2026-10-26
-->
# Rotate List
[Problem Description](https://leetcode.com/problems/rotate-list/description/)

Summary: Given the `head` of a linked list, rotate the list to the right by `k` places.

## Algorithm
Close the list into a ring, then cut it at the new tail.

Rotating right by `k` moves the last `k` nodes to the front. Since `k` can be far larger than the list length `n`, only `r = k % n` matters: rotating by `n` returns the original list.

1. **Edge cases:** if the list is empty or has one node, return `head`.
2. **Find the length and tail:** walk from `head` to the last node, counting `n`.
3. **Close the loop:** set `tail.next = head`, making the list a cycle.
4. **Find the new tail:** the last `r` nodes occupy positions `n - r + 1` through `n` (1-indexed), so the new tail is at position `n - r`. Starting from `head` at position 1, reaching it takes `n - r - 1` steps.
5. **Break the loop:** the new head is `newTail.next`. Set `newTail.next = null` and return the new head.

## Complexity

| Time | Space |
|---|---|
| $O(n)$ | $O(1)$ |

## Notes
- **Rotate left:** rotating left by `k` is the same as rotating right by `n - k % n`.
