# Two Sum II
[Problem Description](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/)

Summary: Given a sorted array of integers, return the indices (1-indexed) of two numbers in the array that sum to the target value.

## Algorithm

We will use two pointers, one at each end of the array. We set the left pointer `i` to the first element, which is also the smallest element, since the array is sorted. Likewise, we set the right pointer `j` to the last element, which is also the largest element. We declare a variable `sum` which is the value of `numbers[i] + numbers[j]`. Then, until the pointers "meet in the middle", we check the following three cases:

1. `sum == target`: The current indices contain the two numbers which sum to the target. Return the current indices (1-indexed).
2. `sum > target`: The current sum is too large. To decrease the overall sum, we must decrement `j` to get a smaller number, since `i` already points to the smallest feasible value so far. 
3. `sum < target`: The current sum is too small. To increase the overall sum, we must increment `i` to get a larger number, since `j` already points to the largest feasible value so far.


## Complexity
| Approach | Time | Space |
|---|---|---|
| Two Pointer | `O(n)` | `O(1)` |

## Notes
The runtime of our algorithm is the same as the hashmap approach from Two Sum, but the space complexity is better under the assumption of a sorted input array. 

The loop invariant is always preserved. Since we are guaranteed that the solution `(lo, hi)` exists and is unique (i.e. `lo < hi`), we have that this solution pair satisfies `i <= lo` and `hi <= j`. In other words, the solution, if not already found, still lies in the current "search window" within `[i, j]`.