<!--
number: 0121
title: Best Time to Buy and Sell Stock
pattern: greedy
difficulty: Easy
languages: Java
slug: best-time-to-buy-and-sell-stock
last_reviewed: 2026-09-23
-->
# Best Time to Buy and Sell Stock
[Problem Description](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/)

Summary: Given an array `prices` where `prices[i]` is the stock price on day `i`, find the maximum profit achievable from buying on one day and selling on a later day. Return `0` if no profit is possible.

## Algorithm
We will perform a single pass through the array and consider the following greedy algorithm:

1. Track the minimum price seen so far (`minPrice`) and the best profit found so far (`maxProfit`) as the array is scanned left to right,
2. At each day, the best possible profit if selling today is `max(maxProfit, currentPrice - minPrice)` since `minPrice` always reflects the best buy price among all strictly earlier days.
3. Update `maxProfit` and `minPrice` accordingly.

Returning `maxProfit` after the array is processed either gives a valid profit or returns its intialized value of `0`.

## Complexity

| Time | Space |
|---|---|
| $O(n)$ | $O(1)$ |

## Notes
- **Greedy justification**: at every index, the only thing that matters for future decisions is the smallest buy price seen so far, not which earlier day it occurred on or any other historical detail. Discarding all other history and keeping just this one running value is what makes the greedy approach valid here, rather than needing to consider all $O(n^2)$ buy/sell day pairs.
