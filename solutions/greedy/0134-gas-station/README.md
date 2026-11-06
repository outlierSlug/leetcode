<!--
number: 0134
title: Gas Station
pattern: greedy
difficulty: Medium
languages: Java
slug: gas-station
last_reviewed: 2026-11-05
-->
# Gas Station
[Problem Description](https://leetcode.com/problems/gas-station/description/)

Summary: There are `n` gas stations arranged in a circle, where station `i` has `gas[i]` fuel and traveling from station `i` to station `i + 1` costs `cost[i]`. Starting with an empty tank, return the index of the starting station from which the full circuit can be completed, or `-1` if no start works. If a solution exists, it is unique.

## Algorithm
A feasibility check, then a single greedy pass that discards failing starts in bulk.

1. **Feasibility:** compute the total net fuel, the sum of `gas[i] - cost[i]`. If it is negative, no start can complete the circuit, so return `-1`.
2. **Greedy pass:** keep a candidate `start` (initially 0) and a `tank` measuring fuel accumulated since `start`. For each station `i`, add `gas[i] - cost[i]` to `tank`. If `tank` drops below 0, station `i + 1` is unreachable from `start`, so set `start = i + 1` and reset `tank` to 0.
3. Return `start`.

**Why every station in `[start, i]` fails at once:** arriving at any station `j` in that range from `start`, the tank held at least 0 fuel. Starting at `j` instead begins with exactly 0, which is never better, so it also cannot get past station `i`.

**Why the final candidate works without simulating the wrap-around:** every discarded segment has a negative net total, and the run from the final `start` to the end never goes negative. Since the overall total is non-negative, the surplus from the final run covers the deficits of the earlier segments.

## Complexity

| Approach | Time | Space |
|---|---|---|
| Greedy | $O(n)$ | $O(1)$ |
| Brute force | $O(n^2)$ | $O(1)$ |

## Notes
- **`start` never exceeds `n - 1`:** if the tank went negative at the last station, every segment would have a negative net total, making the overall total negative. The feasibility check already rules this out.
- **Single-pass variant:** the total can be accumulated inside the greedy loop, returning `total >= 0 ? start : -1` at the end. It saves one pass but does not change the complexity, and checking feasibility first is easier to explain.
- Brute force solution (Python): [Video Solution](https://www.youtube.com/watch?v=TnNW3Oi-IHI)

```python
class Solution:
    def canCompleteCircuit(self, gas: list[int], cost: list[int]) -> int:
        # Brute force solution: O(n^2)
        n = len(gas)
        if sum(gas) < sum(cost): return -1

        def attempt(start_idx):
            i = start_idx
            tank = 0
            force = 1
            while i != start_idx or force:
                force = 0
                tank = tank + gas[i] - cost[i]
                if tank < 0: return False
                i = (i + 1) % n
            return True

        for i in range(n):
            if attempt(i): return i

```
