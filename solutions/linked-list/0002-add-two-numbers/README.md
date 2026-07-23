# Add Two Numbers
[Problem Description](https://leetcode.com/problems/add-two-numbers/description/)

Summary: Given two non-empty linked lists representing two non-negative integers, add the two numbers and return the sum as a linked list. The digits are stored in reverse order.

## Algorithm
The digits being stored in reverse order means we can approach this just like schoolbook addition: start adding at the ones place and carry over if necessary.

First, we create our dummy head node and will use our `curr` pointer to build our result. Then, we will process the digits until both lists are exhausted and there is no more carry. At each step, we do the following:

1. Take the current digit from `l1` and `l2` if they exist, otherwise set it to `0` (no digit is mathematically equivalent to a zero on the left).
2. Compute the value of the sum `v1 + v2  + carry`. This is the schoolbook addition step.
3. Compute the new carry and the digit to store.
4. Create a new node with that digit and attach it to `curr.next`. Then advance `curr`.
5. Advance `l1` and `l2` if they're not already `null`.

Finally, we return `dummy.next` which contains the list of the reversed sum.

## Complexity
Let `n` be the length of `l1` and `m` be the length of `l2`.

| Approach | Time | Space |
|---|---|---|
| Iterative | `O(max(n, m))` | `O(max(n, m))` |

The auxiliary space usage is constant, but we are required to create new nodes for our output result.

## Notes
The elegance of this solution lies in the loop condition, which mirrors the schoolbook addition algorithm perfectly. At the end of each step, everything built so far is correct, and the `carry` is the only unresolved piece which will be processed in the immediate following step.