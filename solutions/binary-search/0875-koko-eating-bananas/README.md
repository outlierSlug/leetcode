<!--
number: 0875
title: Koko Eating Bananas
pattern: binary-search
difficulty: Medium
languages: Java
slug: koko-eating-bananas
last_reviewed: 2026-10-01
-->
# Koko Eating Bananas
[Problem Description](https://leetcode.com/problems/koko-eating-bananas/description/)

Summary: Given banana piles `piles` and `h` hours, find the minimum eating speed `k` (bananas per hour) that lets Koko finish every pile within `h` hours. Each hour she eats from one pile; if it has fewer than `k` bananas, she finishes it and waits for the next hour.

## Algorithm
Binary search on `range(k)`. Speeds that work form a range: if speed `k` finishes in time, every higher speed does too. So the answer is the smallest speed that works, which can be found by binary search over the range of possible speeds.

**Search range:** `lo = 1` (the slowest possible speed) to `hi = max(piles)` (eats any pile in one hour, so this always works).

**Loop:** while `lo < hi`, try `k = lo + (hi - lo) / 2`:
- If `k` works, the answer is `k` or slower, so set `hi = k`.
- If not, the answer is faster, so set `lo = k + 1`.

When `lo == hi`, it's the minimum speed `k` that works.

**Checking k, isValidK:** add up the hours for each pile, `ceil(pile / k)`, and compare the total with `h`.

## Complexity

| Time | Space |
|---|---|
| $O(n \log m)$ | $O(1)$ |

Let $m = max(piles)$, i.e. the largest pile. The binary search runs $O(\log m)$ steps, and each check is $O(n)$.

## Notes
- **Overflow in the hour total:** piles can be up to $10^9$ each, so with a small `k` the total hours can exceed `int`'s limit (about $2.1 \times 10^9$). Store the total as a `long`. With an `int` total, the original `hours += Math.ceil(...)` happened to work only because Java clamps a too-large `double` to `Integer.MAX_VALUE` when converting to `int`. Plain `int` addition would wrap around to a negative number, and a too-slow speed would wrongly pass.
- **Ceiling without floating point:** `(pile + k - 1) / k` rounds up using only whole numbers, avoiding `double` math and any question about rounding error.
- **Midpoint:** `lo + (hi - lo) / 2` avoids the overflow that `(lo + hi) / 2` can cause for large bounds.
