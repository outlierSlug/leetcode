<!--
number: 0035
title: Search Insert Position
pattern: binary-search
difficulty: Easy
languages: Java
slug: search-insert-position
last_reviewed: 2026-09-02
-->
# Search Insert Position
[Problem Description](https://leetcode.com/problems/search-insert-position/description/)

Summary: Given a sorted array of distinct integers `nums` and a `target` value, return the index if the `target` is found. If not, return the index where it would be if it were inserted in order.

## Algorithm
We will run the [Binary Search](../0704-binary-search/) algorithm, but if the `target` is not found we return `lo` instead of `-1`. This is because after the loop runs, `lo` is naturally positioned at the earliest index to keep the array sorted after inserting `target`.

## Complexity

| Time | Space |
|---|---|
| `O(log n)`| `O(1)` |

## Notes

