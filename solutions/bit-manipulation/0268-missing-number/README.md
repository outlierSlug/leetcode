<!--
number: 0268
title: Missing Number
pattern: bit-manipulation
difficulty: Easy
languages: Java
slug: missing-number
last_reviewed: 2026-11-07
-->
# Missing Number
[Problem Description](https://leetcode.com/problems/missing-number/description/)

Summary: Given an array `nums` containing `n` distinct numbers in the range `[0, n]`, return the only number in the range that is missing from the array.

## Algorithm
XOR every element in the array with every index. Since the numbers of from `[0, n]`, XOR-ing every value with every index leaves the missing number, since `a ^ a = 0`. 

## Complexity

| Time | Space |
|---|---|
| $O(1)$ | $O(1)$ |

## Notes

