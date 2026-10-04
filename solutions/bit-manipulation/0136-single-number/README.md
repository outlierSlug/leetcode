<!--
number: 0136
title: Single Number
pattern: bit-manipulation
difficulty: Easy
languages: Java, Python
slug: single-number
last_reviewed: 2026-10-03
-->
# Single Number
[Problem Description](https://leetcode.com/problems/single-number/description/)

Summary: Given a non-empty integer array where every element appears exactly twice except one, which appears once, find that single element in $O(n)$ time and $O(1)$ extra space.

## Algorithm
XOR every element together, starting from `0`. The result is the single element, because of three properties of XOR:
- `a ^ a = 0`: a value XOR-ed with itself cancels out.
- `a ^ 0 = a`: XOR with 0 leaves a value unchanged.
- XOR is commutative and associative, so the elements can be regrouped in any order.

Each pair in the array cancels to `0`, leaving just the single number in `result`.

## Complexity

| Time | Space |
|---|---|
| $O(n)$ | $O(1)$ |

## Notes
- **Starting at 0:** since `0 ^ a = a`, starting the result at `0` and XOR-ing every element with a for-each loop gives the same answer without special-casing the first element.
