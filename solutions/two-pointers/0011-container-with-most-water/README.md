<!--
number: 0011
title: Container With Most Water
pattern: two-pointers
difficulty: Medium
languages: Java
slug: container-with-most-water
last_reviewed: 2026-08-02
-->
# Container With Most Water
[Problem Description](https://leetcode.com/problems/container-with-most-water/description/)

Summary: Given an integer array `height` where each index contains a line of height `height[i]`, find two lines that together with the x-axis form a container, such that the container contains the maximum amount of water.

## Algorithm
We will use a two pointer sweep from the ends of the array, always moving the pointer at the shorter line inwards. At each step, we consider the water area formed by the two pointers, and depending on which line is shorter, we close in the window accordingly.

## Complexity

| Time | Space |
|---|---|
| `O(n)`| `O(1)` |

## Notes
[Neetcode Explanation](https://www.youtube.com/watch?v=UuiTKBwPgAo)

