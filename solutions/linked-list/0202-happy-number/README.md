<!--
number: 0202
title: Happy Number
pattern: linked-list
difficulty: Easy
languages: Java
slug: happy-number
last_reviewed: 2026-09-24
-->
# Happy Number
[Problem Description](https://leetcode.com/problems/happy-number/description/)

Summary: A number is "happy" if repeatedly replacing it with the sum of the squares of its digits eventually reaches `1`. If it enters a cycle that never includes `1`, it is not happy. Given an integer `n`, determine if it is happy.

## Algorithm
Floyd's Cycle Detection Algorithm (tortoise and hare), applied to an implicit sequence rather than a literal linked list: each number's "next" value is deterministically `getSum(number)`, the sum of the squares of its digits. Since the transformation is deterministic and the range of reachable values is bounded, the sequence must either reach `1` or eventually repeat a value, entering a cycle.

Two pointers traverse this implicit sequence at different speeds: `slow` advances one step per iteration, `fast` advances two. If the sequence is happy, `fast` reaches `1` first, since it is always further ahead. If the sequence is not happy, it cycles indefinitely without ever hitting `1`, and the faster pointer will eventually lap the slower one, causing them to collide at some non-1 value.

## Complexity

| Time | Space |
|---|---|
| $O(\log n)$ | $O(1)$ |

## Notes
- The complexity here is informal, since it depends on digit-sum dynamics rather than a clean closed form: repeated digit-squaring shrinks any starting number into a small bounded range quickly, and cycles within that range are short. The key comparison is against a hash-set-based approach (storing every value seen so far to detect repeats), which is also roughly `O(log n)` time but `O(log n)` space; Floyd's approach achieves the same detection with `O(1)` space by using two pointers instead of a set.

