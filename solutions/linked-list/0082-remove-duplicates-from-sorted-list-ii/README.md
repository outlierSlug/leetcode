<!--
number: 0082
title: Remove Duplicates from Sorted List II
pattern: linked-list
difficulty: Medium
languages: Java
slug: remove-duplicates-from-sorted-list-ii
last_reviewed: 2026-10-27
-->
# Remove Duplicates from Sorted List II
[Problem Description](https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/)

Summary: Given the `head` of a sorted linked list, delete all nodes that have duplicate values, leaving only values that appear exactly once in the original list. Return the list, still sorted.

## Algorithm
Dummy node with a `prev` pointer that trails behind runs of duplicates.

Since the list is sorted, duplicates form contiguous runs. Deleting an entire run requires the node **before** it, and the head itself may be part of a run, so a dummy node is placed in front of `head`.

1. Create a `dummy` pointing to `head`. Set `prev = dummy` (the last node confirmed to stay) and `curr = head` (the candidate being checked).
2. While `curr != null`:
   - **Duplicate run** (`curr.next != null` and `curr.val == curr.next.val`): advance `curr` to the last node of the run, then unlink the entire run with `prev.next = curr.next`. Do **not** move `prev`, since the next node may start another run.
   - **Unique node:** it stays, so set `prev = curr`.
   - Advance `curr = curr.next`.
3. Return `dummy.next`.

**Invariant:** at the top of every iteration, `prev.next == curr`. Both branches restore it, which is why `prev` never needs to search for its successor.

## Complexity

| Time | Space |
|---|---|
| $O(n)$ | $O(1)$ |

## Notes
- The time complexity is linear: the inner loop only advances `curr`, which never moves backward, so each node is visited a constant number of times.
