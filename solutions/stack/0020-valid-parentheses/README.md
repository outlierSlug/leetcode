<!--
number: 0020
title: Valid Parentheses
pattern: stack
difficulty: Easy
languages: Java
slug: valid-parentheses
last_reviewed: 2026-08-27
-->
# Valid Parentheses
[Problem Description](https://leetcode.com/problems/valid-parentheses/description/)

Summary: Given a string `s` containing only opening and closing brackets, determine if the input string is valid, i.e. all opening brackets are closed in the correct order by their respective closing brackets.

## Algorithm
We will use a Stack to parse the input string and a HashMap to pair closing brackets with their respective opening brackets. Using a single pass through `s`, we take each character `c` and check:
1. If `c` is a closing bracket (`pairs.containsKey(c)`), then we `peek` the stack and `pop` if and only if the stack is not empty and the `peek` character is exactly the pair of the current closing bracket.
2. Otherwise, if `c` is an opening bracket, we simply push it to the stack.
If the string is valid, then the stack should be empty after we parse the string. Thus, we return `stack.isEmpty()`.


## Complexity

| Time | Space |
|---|---|
| `O(n)`| `O(n)` |

Auxiliary space usage is at worst `O(n)` if every character in the string is an opening bracket.

## Notes
Use `.equals()` to compare by value instead of `!=`, which compares by reference.
