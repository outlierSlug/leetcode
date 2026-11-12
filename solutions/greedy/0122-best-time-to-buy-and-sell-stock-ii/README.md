<!--
number: 0122
title: Best Time to Buy and Sell Stock II
pattern: greedy
difficulty: Medium
languages: Java
slug: best-time-to-buy-and-sell-stock-ii
last_reviewed: 2026-11-11
-->
# Best Time to Buy and Sell Stock II
[Problem Description](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/)

Summary: Given an array `prices` where `prices[i]` is the price of a stock on day `i`, return the maximum profit achievable. Any number of transactions is allowed, but at most one share can be held at a time. Selling and buying again on the same day is allowed.

## Algorithm
Greedy: collect every positive day-to-day price increase.

For each day `i` from 1 to `n - 1`, if `prices[i] > prices[i - 1]`, add the difference to the profit. Return the total.

**Why this is optimal:**
1. **Transactions decompose into daily steps.** Buying on day `i` and selling on day `j` earns `prices[j] - prices[i]`, which equals the sum of the daily changes from `i` to `j`, since the intermediate prices cancel.
2. **Every strategy's profit is a sum of daily changes.** Transactions cannot overlap, so each daily change is counted at most once.
3. **The greedy total is an upper bound and is achievable.** No strategy can exceed the sum of all positive daily changes, and buying before each rising day and selling after it earns exactly that sum.

## Complexity

| Time | Space |
|---|---|
| $O(n)$ | $O(1)$ |

## Notes
- [Neetcode Solution](https://www.youtube.com/watch?v=3SJ3pUkPQMc)
