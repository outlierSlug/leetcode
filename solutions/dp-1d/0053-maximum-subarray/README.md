<!--
number: 0053
title: Maximum Subarray
pattern: dp-1d
difficulty: Medium
languages: Java
slug: maximum-subarray
last_reviewed: 2026-10-06
-->
# Maximum Subarray
[Problem Description](https://leetcode.com/problems/maximum-subarray/description/)

Summary: Find the contiguous subarray with the largest sum and return that sum.

## Algorithm
1. Initialize `maxSub = nums[0]` (the best answer seen so far) and `curSum = 0`.
2. For each `num`:
   - If `curSum < 0`, reset it to `0`, since a negative prefix can only lower any sum that extends it.
   - Add `num` to `curSum`. It now holds the best sum of a subarray ending at `num`.
   - Update `maxSub = max(maxSub, curSum)`.
3. Return `maxSub`.

The greedy reset above is a space-optimized dynamic programming solution.
 
- **State:** `dp[i]` = maximum sum of a subarray that **ends at** index `i`. Requiring the subarray to end at `i` is what makes the transition possible, because it tells you whether `nums[i+1]` can extend it.
- **Transition:** a subarray ending at `i` either starts fresh at `nums[i]` or extends the best subarray ending at `i-1`:
```
  dp[i] = max(nums[i], dp[i-1] + nums[i])
```
 
- **Base case:** `dp[0] = nums[0]`
- **Answer:** `max(dp[i])` over all `i`, since the optimal subarray must end somewhere.
- **Space optimization:** `dp[i]` depends only on `dp[i-1]`, so a single variable replaces the array.
**Equivalence to the greedy reset:** `max(nums[i], dp[i-1] + nums[i])` picks `nums[i]` exactly when `dp[i-1] < 0`, which is the condition under which this solution resets `curSum` to `0` before adding.

## Complexity

| Time | Space |
|---|---|
| $O(n)$ | $O(1)$ |

## Notes
- [NeetCode Solution](https://youtu.be/5WZl3MMT0Eg)
