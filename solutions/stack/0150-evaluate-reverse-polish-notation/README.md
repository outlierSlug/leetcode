<!--
number: 0150
title: Evaluate Reverse Polish Notation
pattern: stack
difficulty: Medium
languages: Java
slug: evaluate-reverse-polish-notation
last_reviewed: 2026-08-28
-->
# Evaluate Reverse Polish Notation
[Problem Description](https://leetcode.com/problems/evaluate-reverse-polish-notation/description/)

Summary: Evaluate an arithmetic expression given in Reverse Polish (postfix) notation, where operators follow their operands.

## Algorithm
We will scan the tokens from left to right, maintaining a stack of operands.
- If the token is a number, we push it onto the stack.
- If the token is an operator, we pop two numbers off the stack, the first one popped is the second operand, and the next one is the first operand. Then, we perform the proper arithmetic and push the resulting number back on the stack.

After all tokens have been processed, the answer is the last value in the stack.

## Complexity

| Time | Space |
|---|---|
| `O(n)`| `O(n)` |

## Notes
- Operand order matters for non-commutative operators like subtraction and division. The first value popped is the second operand.
- Checking operator membership via a fixed `Set.of()` is clearer and more robust than a denser `if` statement check for if a token is a number.
