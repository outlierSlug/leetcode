<!--
number: 0300
title: Longest Increasing Subsequence
pattern: dp-1d
difficulty: Medium
languages: Java
slug: longest-increasing-subsequence
last_reviewed: 2026-09-22
-->
# Longest Increasing Subsequence
[Problem Description](https://leetcode.com/problems/longest-increasing-subsequence/description/)

Summary: Given an integer array `nums`, return the length of the longest strictly increasing subsequence. Elements of the subsequence do not need to be contiguous, but must preserve their original relative order.

## Algorithm
DP over "subsequence ending at index `i`." Because the LIS can end at any index, the final answer is not `dp(n-1)`, but the max over the entire `dp[]` array.
For each `i`, every earlier index `j < i` with `nums[j] < nums[i]` is a candidate predecessor, so the state space is scanned left to right and each state's transition considers all smaller indices rather than a fixed number of them.

## Recurrence
Let $\text{dp}(i)$ be the length of the longest increasing subsequence ending exactly at index $i$, for $0 \le i \le n-1$.

```math
\text{dp}(i) = \max\left(1,\ \max_{\substack{0 \,\le\, j \,<\, i \\ \text{nums}[j] \,<\, \text{nums}[i]}} \big(1 + \text{dp}(j)\big)\right)
```

**Base Case:** every index trivially forms a subsequence of length 1 by itself, so $\text{dp}(i) \ge 1$ for all $i$.

**Recursive Case:** the second-to-last element in an increasing subsequence ending at index $i$ was some earlier index $j < i$ with a strictly smaller value, $\text{nums}[j] < \text{nums}[i]$. Extending the best subsequence ending at $j$ by appending $\text{nums}[i]$ gives a subsequence of length $1 + \text{dp}(j)$. Since the identity of that predecessor is not known in advance, every valid $j$ is tried, and the max across all candidates (together with the base value of 1, covering the case where no valid predecessor exists) gives $\text{dp}(i)$.

**Final Answer:** The LIS does not necessarily end at the last index of `nums`. Instead, we take the max over `dp`:

```math
\max_{0 \,\le\, i \,\le\, n-1} \text{dp}(i)
```

## Complexity

| Time | Space |
|---|---|
| $O(n^2)$| $O(n)$ |

For each `i`, the inner loop scans all `j < i`, so the total work sums to a triangular series across all `i`, giving $O(n^2)$ overall.

## Notes
- **Binary Search Solution**: Maintain an array `tails`, where `tails[k]` is the smallest possible tail value among all increasing subsequences of length `k + 1` found so far. Scanning left to right, each `num` either extends `tails` (if it's larger than every current tail) or replaces the first entry in `tails` that is `>= num` (found via binary search, since `tails` stays sorted). The final length of `tails` is the answer. Note that `tails` itself is not necessarily a real subsequence found in `nums`, only a bookkeeping structure whose length happens to equal the answer.

```java
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int num : nums) {
            int result = Arrays.binarySearch(tails, 0, size, num);
            int pos = result < 0 ? -result - 1 : result;
            tails[pos] = num;
            if (pos == size) {
                size++;
            }
        }
        return size;
    }
}
```
- Note that `Arrays.binarySearch` returns a negative value if `num` is not found: `result = -(insertion_point) - 1` which we handle with `int pos = result < 0 ? -result - 1 : result;`.
- With binary search, the overall runtime of the algorithm is $O(n\log n)$.