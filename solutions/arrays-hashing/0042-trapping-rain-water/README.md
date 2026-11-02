<!--
number: 0042
title: Trapping Rain Water
pattern: arrays-hashing
difficulty: Hard
languages: Java
slug: trapping-rain-water
last_reviewed: 2026-11-01
-->
# Trapping Rain Water
[Problem Description](https://leetcode.com/problems/trapping-rain-water/description/)

Summary: Given `n` non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

## Algorithm
Prefix and suffix maxima.

The water above index `i` is limited by the tallest bar on each side, and it fills up to the shorter of the two:

$$
\text{water}[i] = \max\big(0,\ \min(\text{maxLeft}[i],\ \text{maxRight}[i]) - \text{height}[i]\big)
$$

1. Build `maxLeft[i]`, the tallest bar strictly left of `i`, and `maxRight[i]`, the tallest bar strictly right of `i`. Both fill in a single loop: index `i` sweeps left to right and `j = n - i - 1` sweeps right to left, each storing its running wall **before** including the current bar.
2. Sum `max(0, min(maxLeft[i], maxRight[i]) - height[i])` over all `i`.

## Complexity

| Time | Space |
|---|---|
| $O(n)$ | $O(n)$ |

## Notes

