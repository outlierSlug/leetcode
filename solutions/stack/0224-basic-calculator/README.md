<!--
number: 0224
title: Basic Calculator
pattern: stack
difficulty: Hard
languages: Java
slug: basic-calculator
last_reviewed: 2026-08-29
-->
# Basic Calculator
[Problem Description](https://leetcode.com/problems/basic-calculator/description/)

Summary: Evaluate a string expression containing non-negative integers, `+`, `-`, and parentheses, respecting standard precedence and nesting.

## Algorithm
We will perform a single pass through the string, tracking the running `result`, the current `sign` (positive or negative), and the number `num` currently being accumulated. At each iteration, depending on `c = charAt(i)`, we perform the following:
- Digits (0-9): Accumulate into `num` via `num = num * 10 + digit` (handles multi-digit numbers)
- `+` or `-`: Flush the pending `num` into `result` using the *current* `sign`, then  set `sign` for the next number.
- `(`: Push the current `result` and `sign` onto the stack (state to restore after sub-expression evaluates), then reset `result = 0, sign = 1, num = 0` to evaulate the parenthesized sub-expression
- `)`: Flush the pending `num` into `result` first, then pop the saved outer `sign` and `result`, combining into `result = prevSign * subExpressionResult + prevResult`.

Note that whitespace characters are simply skipped. After the loop, one final flush is needed for the last pending `num`. After which we simply return `result`.

## Complexity

| Time | Space |
|---|---|
| `O(n)`| `O(n)` |

## Notes
- The recurring pattern is "flush pending number before acting on the character that ended it". This applies to any operator and the closing parentheses.
