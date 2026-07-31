<!--
number: 0169
title: Majority Element
pattern: arrays-hashing
difficulty: Easy
languages: Java, Python
slug: majority-element
last_reviewed: 2026-07-28
-->
# Majority Element
[Problem Description](https://leetcode.com/problems/majority-element/description/)

Summary: Given an array `nums`, return its majority element.

## Algorithm
My initial intuition for this problem led me to use a HashMap to keep track of the counts of each number in the array, find the one with the highest count, and return that number.

However, there is a more efficient solution called the Boyer-Moore Algorithm which solves this problem with `O(1)` space and a single pass through the array. The way it works is that it takes a candidate number, and if we encounter the same number, we increment the count, otherwise we decrement the count. Once `count == 0`, we take the next element as the new candidate and perform the same loop. The majority element is guaranteed to "survive" this process and be the final candidate element at the end of the array.

## Complexity

| Approach | Time | Space |
|---|---|---|
| HashMap | `O(n)` | `O(n)` |
| Boyer-Moore | `O(n)` | `O(1)` |

## Notes
The Boyer-Moore Algorithm only works because we are guaranteed to have a majority element in the array.