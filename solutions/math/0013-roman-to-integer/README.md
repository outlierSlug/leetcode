<!--
number: 0013
title: Roman To Integer
pattern: math
difficulty: Easy
languages: Java
slug: roman-to-integer
last_reviewed: 2026-07-30
-->
# Roman to Integer
[Problem Description](https://leetcode.com/problems/roman-to-integer/description/)

Summary: Given a roman numeral, convert it to an integer.

## Algorithm
We will first build a HashMap `romanMap` with symbols as keys and the corresponding integer values as values. Then, we initialize the `result` with the last roman numeral in the string, which is always added to the numerical value. Then, we do a single pass through the string and perform the following:

1. Check the current numeral at index `i` with the numeral at index `i + 1`. If the current numeral is smaller, then we subtract its value from `result`.
2. Otherwise, we add its value to `result`.
3. We continue until we have finished processing all but the last numeral (which we intialized `result` with).

The reason this works is because roman numerals have a nice mathematical property, where the special cases of having a smaller numeral in front of a larger numeral corresponds exactly to this algorithm. For example, `XIV = 14` is composed of `10 - 1 + 5 = 14`, where `IV = 4`. 

## Complexity

| Time | Space |
|---|---|
| `O(n)` | `O(1)` |

## Notes
The space complexity is bounded by the number of unique roman numerals, which in this case is constant.