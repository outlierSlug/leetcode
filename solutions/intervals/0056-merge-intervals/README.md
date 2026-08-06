<!--
number: 0056
title: Merge Intervals
pattern: intervals
difficulty: Medium
languages: Java
slug: merge-intervals
last_reviewed: 2026-08-05
-->
# Merge Intervals
[Problem Description](https://leetcode.com/problems/merge-intervals/description/)

Summary: Given an array of `intervals`, merge all overlapping intervals and return an array of the non-overlapping intervals that cover all intervals in the input.

## Algorithm
First, we will sort the intervals by start time ascending. Then, we will add the first interval to our `merged` list which is the result being built. For the remaining intervals, we then do the following:

1. Take the `current` interval, and the `last` added interval in `merged`. 
2. If the start time of the `current` interval (`current[0]`) is less than or equal to the end time of the `last` interval (`last[1]`), then we have overlap. Set the end time of the `last` interval to the max of the `current` end and the `last` end.
3. Otherwise, there is no overlap. We simply add the current interval to the `merged` list.
4. We return the result by using `merged.toArray(new int[0][])` which efficiently converts the type to the desired `int[][]`. 
## Complexity

| Time | Space |
|---|---|
| `O(n log n)`| `O(n)` |

The `Arrays.sort()` method dominates runtime as it is an `O(n log n)` operation. The merge step is linear. The space complexity is `O(n)`, since the output array stores at worst `n` intervals. If we do not count the output, the worst-case space complexity remains linear because of Java's sorting overhead.

## Notes
Note the code syntax for sorting the intervals by start time:
```java
Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
```
Additionally, the final return step calls `merged.toArray(new int[0][])`, which simply automatically types the list to an `int[][]` of correct size (and avoids a call to `merged.size()`).

