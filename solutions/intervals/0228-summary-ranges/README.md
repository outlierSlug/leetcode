<!--
number: 0228
title: Summary Ranges
pattern: intervals
difficulty: Easy
languages: Java
slug: summary-ranges
last_reviewed: 2026-08-05
-->
# Summary Ranges
[Problem Description](https://leetcode.com/problems/summary-ranges/description/)

Summary: Given a sorted unique integer array `nums`, return the smallest sorted list of ranges that cover all numbers in the range exactly.

## Algorithm
We will perform a single pass through the array and utilize two pointers to keep track of the `start` and `end` of potential ranges. 
1. Take `nums[i]` as our `start`, this is the beginning of the range.
2. Increment `i` until the next element is no longer exactly `1` more than the current element. This indicates that we have reached the end of a range.
3. The new `nums[i]` is our `end`.
4. If `start != end`, then we have a range and we add it to the `result` list, properly formatted.
5. Otherwise, we have a singular number (no range) so we add it as a string to the `result` list.

## Complexity

| Time | Space |
|---|---|
| `O(n)`| `O(1)` |

The output array is of size `k`, where `k` is the number of intervals in the resulting list. However, besides that there is constant auxiliary space usage.

## Notes
Each index `i` is visited exactly once across the combined work of the `for` loop and nested `while`, so the total work is bounded by `O(n)`.