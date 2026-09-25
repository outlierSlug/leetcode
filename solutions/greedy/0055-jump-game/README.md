<!--
number: 0055
title: Jump Game
pattern: greedy
difficulty: Medium
languages: Java
slug: jump-game
last_reviewed: 2026-09-24
-->
# Jump Game
[Problem Description](https://leetcode.com/problems/jump-game/description/)

Summary: Given an array `nums` where `nums[i]` is the maximum jump length from index `i`, determine if the last index is reachable starting from index `0`. Jumps only move forward, and only reachability matters, not the path or minimum number of jumps taken.

## Algorithm
We will perform a greedy single pass through `nums`. 

Track `furthest`, the rightmost index reachable given everything seen so far. At each index `i`, first check whether `i` itself is even reachable: if `i > furthest`, no jump seen so far can reach `i`, so the last index is unreachable and the answer is `false` immediately. Otherwise, extend `furthest` using `i + nums[i]`, the farthest this index alone can reach.

The early exit for `true` triggers as soon as `furthest >= nums.length - 1`, since reaching the last index is the only thing that needs to be proven, and continuing to scan further indices adds no new information once that's already guaranteed.

## Complexity

| Time | Space |
|---|---|
| $O(n)$ | $O(1)$ |

## Notes
- **Greedy justification**: the only thing that ever matters for future decisions is the single farthest index reachable so far, not *which* earlier index produced that reach or what any other reachable-but-shorter jump could have achieved instead. If index `i` is reachable via some jump, then every index between the jump's origin and `i` is also reachable (or reachable-adjacent), so tracking anything more granular than a single running maximum discards no useful information. This is what makes collapsing the problem to one variable valid, rather than needing to track the full set of reachable indices.
