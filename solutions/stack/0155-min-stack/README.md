<!--
number: 0155
title: Min Stack
pattern: stack
difficulty: Medium
languages: Java
slug: min-stack
last_reviewed: 2026-08-28
-->
# Min Stack
[Problem Description](https://leetcode.com/problems/min-stack/description/)

Summary: Design a stack supporting `push`, `pop`, `top`, and `getMin`, with all operations in `O(1)` time.

## Algorithm
We will design the class with two fields `stack` and `minStack` which will be maintained in parallel.
- `stack` is the actual data with standard stack behavior.
- `minStack` stores the min value of `stack` up to that index in `stack`.

On `push(value)`, we push the value onto `stack` and push `min(value, current min)` onto `minStack` (or just `value` if `minStack` is empty).

On `pop()`, pop both stacks together to keep them in sync. `minStack` will correctly "restore" the previous minimum.

On `top()` and `getMin()`, just peek `stack` and `minStack` respectively.

## Complexity

| Operation | Time | Space |
|---|---|---|
| `push` | `O(1)` | `O(1)` amortized (`O(n)` total across n pushes) |
| `pop` | `O(1)` | — |
| `top` | `O(1)` | — |
| `getMin` | `O(1)` | — |
| Overall | | `O(n)` (two stacks of equal size) |

## Notes
The Java solution file is named `MinStack.java` to match the public class name structure.
