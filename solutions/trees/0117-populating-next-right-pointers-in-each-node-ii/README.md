<!--
number: 0117
title: Populating Next Right Pointers in Each Node II
pattern: trees
difficulty: Medium
languages: Java
slug: populating-next-right-pointers-in-each-node-ii
last_reviewed: 2026-10-17
-->
# Populating Next Right Pointers in Each Node II
[Problem Description](https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/description/)

Summary: Given a binary tree where each node has an extra `next` pointer, set each `next` to the node immediately to its right on the same level, or `null` if it is the last node on its level. The tree is not necessarily perfect or complete.

## Algorithm
Walk the tree one level at a time, using each level's already-set `next` pointers to move across it, and build the level below as a linked list while doing so.

- **Outer loop (one round per level):** create a `dummy` node as a fake head for the next level, and a `tail` pointer starting at `dummy`.
- **Inner loop (across the current level):** for each node `curr`, if `curr.left` exists, attach it at `tail.next` and move `tail` forward. Then do the same for `curr.right`. Move to `curr.next`.
- **Move down:** after finishing the level, `dummy.next` is the leftmost node of the next level, whichever parent it came from. Set `curr` to it. If no children were found, it is `null`, and the loop ends.

The `next` pointers set while walking one level are exactly what the inner loop uses to walk the level below in the next round.

## Complexity

| Time | Space |
|---|---|
| $O(n)$ | $O(1)$ |

## Notes
- This solution also works for Populating Next Right Pointers in Each Node (116).
