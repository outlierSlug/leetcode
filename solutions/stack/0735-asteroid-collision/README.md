<!--
number: 0735
title: Asteroid Collision
pattern: stack
difficulty: Medium
languages: Java
slug: asteroid-collision
last_reviewed: 2026-11-08
-->
# Asteroid Collision
[Problem Description](https://leetcode.com/problems/asteroid-collision/description/)

Summary: Given asteroids in a row moving right (positive) or left (negative) at equal speed, simulate all collisions (smaller explodes, equal sizes both explode) and return the survivors.
 
## Algorithm
We will scan the asteroids from left to right, maintaining a stack of survivors. The stack never contains a right-mover directly beneath a left-mover, so there are no pending collisions among survivors.
- If the asteroid is moving right, we push it. It cannot hit anything to its left.
- If the asteroid is moving left, it collides with right-movers on top of the stack:
  - While the top is a smaller right-mover, we pop it and keep going.
  - If the top is an equal right-mover, we pop it and the incoming asteroid is also destroyed.
  - If the top is a larger right-mover, the incoming asteroid is destroyed.
  - If the stack is empty or the top is a left-mover, the incoming asteroid survives and we push it.
An `alive` flag tracks whether the incoming asteroid survives the loop. After all asteroids are processed, the stack from bottom to top is the answer.

## Complexity

| Time | Space |
|---|---|
| $O(n)$ | $O(n)$ |

## Notes
- Each asteroid is pushed and popped at most once, so the nested loop is `O(n)` amortized, not `O(n^2)`.
- A left-mover followed by a right-mover never collides since they move apart, so left-movers on the stack are safe forever.
- The loop must stop once the incoming asteroid is destroyed (`break`), otherwise the larger-top case loops forever and the equal case wrongly keeps destroying asteroids.
- `ArrayDeque.push` adds to the front, so popping returns survivors top-first. Fill the result array from the back.
