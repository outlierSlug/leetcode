# Reverse Linked List
[Problem Description](https://leetcode.com/problems/reverse-linked-list/description/)

Summary: Given the `head` of a singly linked list, return the reversed list.

## Algorithm
We will use three pointers: `prev`, `curr`, and `next` to iteratively reverse the list. 

Starting with `prev = null` and `curr = head`, for each node we do the following:
1. `next = curr.next` : Save the remaining part of the original list.
2. `curr.next = prev` : Reverse the current node's pointer.
3. `prev = curr` : Advance the `prev` pointer.
4. `curr = next` : Advance the `curr` pointer.

Then, we loop until `curr` is `null`, then return `prev`, which will point at the head of the newly reversed list.

## Complexity

| Approach | Time | Space |
|---|---|---|
| Iterative | `O(n)` | `O(1)`

## Notes
The algorithm is easier to visualize with a small example. This three-pointer shuffle generalizes well to these types of problems.