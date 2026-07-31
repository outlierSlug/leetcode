<!--
number: 0142
title: Linked List Cycle II
pattern: linked-list
difficulty: Medium
languages: Java
slug: linked-list-cycle-ii
last_reviewed: 2026-07-24
-->
# Linked List Cycle II
[Problem Description](https://leetcode.com/problems/linked-list-cycle-ii/description/)

Summary: Given the `head` of a linked list, return the node where a cycle begins, if it exists. If there is no cycle, return `null`.

## Algorithm
We can use Floyd's Cycle Detection Algorithm to find the node at which the `slow` and `fast` pointers meet. Then, we can reset `slow` to the `head` and move both `slow` and `head` one node forward at a time. The point at which they meet is the node where the cycle begins. This convergence can be [mathematically proven](https://en.wikipedia.org/wiki/Cycle_detection#Floyd's_tortoise_and_hare).

## Complexity

| Approach | Time | Space |
|---|---|---|
| Floyd's | `O(n)` | `O(1)` |

## Notes
We need an additional check after the first while loop ends to determine whether the loop ended because we reached the end of the linked list (no cycle detected) and return `null`.