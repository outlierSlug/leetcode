<!--
number: 0257
title: Insert Interval
pattern: intervals
difficulty: Medium
languages: Java
slug: insert-interval
last_reviewed: 2026-08-11
-->
# Insert Interval
[Problem Description](https://leetcode.com/problems/insert-interval/description/)

Summary: Given an array of non-overlapping intervals `intervals` and a new interval `newInterval`, insert `newInterval` into `intervals` such that `intervals is still sorted in ascending order by start time, and an overlapping intervals are merged if necessary.

## Algorithm
Since the input array is sorted, we will perform a single pass through the array and build the `result` array by handling three cases:
1. First, append all intervals that end strictly before `newInterval` starts.
2. Then, consider the intervals that overlap with `newInterval`. That is, the intervals which start before `newInterval` ends. We will change the start and end of `newInterval` based on the min start and max end times across all overlapping intervals, and append it to `result`.
3. Finally, we just need to add the remaining intervals which start strictly after `newInterval` ends, and return `result`.

## Complexity

| Time | Space |
|---|---|
| `O(n)`| `O(1)` |

The `result` array is `O(n)` space but is required regardless of approach. There is constant auxiliary space usage otherwise.

## Notes
It is possible to simply append `newInterval` to the list, re-sort, and run the [Merge Intervals](../0056-merge-intervals/) algorithm on the new list, but that would be `O(n log n)` time.
