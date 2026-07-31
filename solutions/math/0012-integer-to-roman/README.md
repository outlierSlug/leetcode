<!--
number: 0012
title: Integer to Roman
pattern: math
difficulty: Medium
languages: Java
slug: integer-to-roman
last_reviewed: 2026-07-30
-->
# Integer to Roman
[Problem Description](https://leetcode.com/problems/integer-to-roman/description/)

Summary: Given an integer, convert it to a Roman numeral.

## Algorithm
We will convert the integer to a Roman numeral via a greedy single-pass approach. First, we initialize two parallel arrays that represent the mapping between every possible symbol and symbol combination and its corresponding integer value (this includes the special cases like `IV = 4, IX = 9`).

Now we consider every possible symbol and do the following:
1. While the current `num` is greater than or equal to the current symbol, we append the symbol to the `result` string and subtract its value from `num`.
2. This works because of the mathematical structure of the roman numeral system. We will always have the most efficient combinations of numerals for the number as we break it down in one pass.


## Complexity

| Time | Space |
|---|---|
| `O(1)` | `O(1)` |

## Notes
If we consider the complexity in terms of the output string, then both time and space complexity is `O(n)` where `n` is the length of the output string. Otherwise, the input and map size is bounded and is essentially constant.