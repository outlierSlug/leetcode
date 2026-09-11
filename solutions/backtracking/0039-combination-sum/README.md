<!--
number: 0039
title: Combination Sum
pattern: backtracking
difficulty: Medium
languages: Java
slug: combination-sum
last_reviewed: 2026-09-10
-->
# Combination Sum
[Problem Description](https://leetcode.com/problems/combination-sum/description/)

Summary: Given an array of distinct positive integers `candidates` and an integer `target`, return all unique combinations that sum to the target. The same number may be reused unlimited times.

## Algorithm
We will use the traditional backtracking pattern (choose, recurse, un-choose) using the `start` index trick to avoid duplicate combinations differing in order. However, we wil pass `start = i` so that the same candidate number can be reused multiple times.

We will track `remaining` (`target` minus the running sum of `current`) rather than the running sum itself, so completion is a simple check:
- **Base case:** `remaining == 0` means the current combination sums exactly to target, and we add a copy to `result`.
- **Overshoot case:** `remaining < 0` means the current path summed past the target, which is invalid. Backtrack immediately.
- **Recursive case:** for each candidate from `start` onward, choose it, recurse with `remaining -= candidates[i]` and `start = i` (allowing reuse), then un-choose.

## Complexity

| Time | Space |
|---|---|
| Exponential, roughly `O(n^(target/minCandidate))`| `O(target/minCandidate)` auxiliary (max recursion depth) |

## Notes
- Unlike [Combinations](../0077-combinations/) (each number used at most once) and [Permutations](../0046-permutations/) (every element used exactly once), this allows unlimited reuse of any candidate, which is why we pass `i`, not `i + 1`, as the next `start` in the next recursive call.
- **Sorting optimization:** sort `candidates` once at the start, then in the loop, `break` as soon as `candidates[i] > remaining` (rather than recursing and relying on the `remaining < 0` base case to catch the overshoot one level deeper). Since the array is sorted, one overshoot guarantees every later candidate in that loop also overshoots, so `break` (not `continue`) skips the rest of the loop entirely.
- This pruning is a real practical speedup (avoids wasted recursive calls and their overhead) but does **not** change the asymptotic worst-case time complexity. The underlying search space size is unchanged; pruning just avoids some function-call overhead for guaranteed-invalid branches.

```java
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);  // sorting optimization
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int remaining, int start, List<Integer> current, List<List<Integer>> result) {
        if (remaining == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > remaining) break;  // prune this branch, no more valid candidates possible
            current.add(candidates[i]);
            backtrack(candidates, remaining - candidates[i], i, current, result);
            current.remove(current.size() - 1);
        }
    }
}
```