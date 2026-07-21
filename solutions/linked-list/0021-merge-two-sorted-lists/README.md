# Merge Two Sorted Lists
[Problem Description](https://leetcode.com/problems/merge-two-sorted-lists/description/)

Summary: Given the heads of two sorted linked lists, merge the two lists into one sorted list. Return the head of the merged linked list.

## Algorithm
We will use a `dummy` head node (to avoid special cases involving the head of the resulting list) and walk `list1` and `list2` together with a `curr` pointer that tracks the tail of the merged list so far. 

At each step, we do the following:
1. Compare the currernt heads of `list1` and `list2`. Attach the node with the smaller value to `curr.next`.
2. Advance that list's pointer past the node just used.
3. Advance `curr` to the newly attached node.
4. Repeat until one list is exhausted. Since the remaining list is already sorted, attach the rest of that list to `curr.next`.
5. Return `dummy.next` as the merged list's real head.

## Complexity
Let `n` and `m` be the lengths of `list1` and `list2` respectively.

| Approach | Time | Space |
|---|---|---|
| Iterative | `O(n + m)` | `O(1)` |
| Recursive | `O(n + m)` | `O(n + m)` |

A potential recursive solution comes at the cost of extra space from the call stack.

## Notes
- The dummy node pattern generalizes to most "build/modify a list" problems, removing the need to special-case whichever node becomes the head.

- `<=` in the list value comparison keeps the merge *stable* (preserving the relative order of equal nodes between the lists).

- After the main loop, at most *one* of `list1`/`list2` is non-null — a ternary (`curr.next = list1 != null ? list1 : list2`) expresses this invariant more directly than two separate `if` checks.