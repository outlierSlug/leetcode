# Linked List Cycle
[Problem Description](https://leetcode.com/problems/linked-list-cycle/description/)

Summary: Given the `head` of a linked list, determine if the linked list has a cycle in it.

## Algorithm
We will use Floyd's Cycle Detection Algorithm, aka the Tortoise and Hare Algorithm. This uses two pointers, a `slow` one that moves 1 node at a time, and a `fast` one that moves 2 nodes at a time. If there is a cycle, these pointers will eventually meet, at which point we return `true`. Otherwise, if the `fast` pointer hits `null`, then there is no cycle and we return `false`.

## Complexity

| Approach | Time | Space |
|---|---|---|
| Floyd's | `O(n)` | `O(1)` |
| Hashset | `O(n)` | `O(n)` |

A hashset solution is possible by tracking visited nodes, but has a linear space complexity with the potential of storing every node in the linked list. Floyd's is the more elegant and efficient solution.

## Notes
[NeetCode Explanation](https://www.youtube.com/watch?v=gBTe7lFR3vc)