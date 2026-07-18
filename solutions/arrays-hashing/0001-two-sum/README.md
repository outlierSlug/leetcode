# Two Sum
[Problem Description](https://leetcode.com/problems/two-sum/description/)

Summary: Given an array of integers, return the indices of two numbers which add up to a target number.

## Algorithm

We will use a single pass through the array, storing each value and its index as a key-value pair in a hashmap. For each number, we check if its complement (target - num) is already in the map, which means that these are the two indices to return. Otherwise, we insert that number into the map and move to the next index.

## Complexity

| Approach | Time | Space |
|---|---|---|
| Hashmap  | `O(n)` | `O(n)` |
| Brute force | `O(n²)` | `O(1)` |

With a single pass through the array, the worst-case runtime of our algorithm is `O(n)`. Similarly, we may have to store every element of the array in the map in the worst-case, so we have an `O(n)` space complexity.

The brute force approach is to use a doubly-nested for loop to compare every element with every other element in the array, which has an `O(n^2)` runtime and an `O(1)` space complexity.

## Notes
Checking for the complement *before* inserting the number into the map ensures that we avoid matching a number with itself (which is not allowed).