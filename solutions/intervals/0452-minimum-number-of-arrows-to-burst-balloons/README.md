<!--
number: 0452
title: Minimum Number of Arrows to Burst Balloons
pattern: intervals
difficulty: Medium
languages: Java
slug: minimum-number-of-arrows-to-burst-balloons
last_reviewed: 2026-08-12
-->
# Minimum Number of Arrows to Burst Balloons
[Problem Description](https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/)

Summary: Balloons represent intervals in a 2D array `points`. An arrow fired at `x` travels vertically upward and hits all balloons/intervals that have `x`. Return the minimum number of arrows needed to pierce all balloons (hit all intervals).

## Algorithm
First ,we will sort the intervals by end time ascending. Then, we will perform a greedy pass through the intervals, always shooting at the end of the next non-overlapping interval. 

The greedy claim is: always shoot your arrow at the end coordinate of the earliest-ending balloon. Why does this work? It is because that position is the rightmost possible point that still guarantees hititng that balloon. It maximizes the efficiency of covering any overlapping intervals and still guarantees hitting the current interval, since intervals have been sorted by end time.


## Complexity

| Time | Space |
|---|---|
| `O(n log n)`| `O(n)` |

Time complexity is dominated by the sort, the scan itself is `O(n)`. While there is constant auxiliary space, depending on Java's sort implementation, up to a worst-case linear space complexity may be used.

## Notes
Using `Integer.compare(a[1], b[1])` is safer to avoid overflow.

