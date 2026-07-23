# Merge Sorted Array
[Problem Description](https://leetcode.com/problems/merge-sorted-array/description/)

Summary: Given two sorted integer arrays `nums1` and `nums2`, merge them into a single sorted array, stored inside `nums1`, which has a length of `m + n`, with the last `n` elements set to `0`.

## Algorithm
We will use three pointers, `i`,`j`, `k`, and work backwards. The setup is as follows:
- `i` will point at the last valid element in `nums1` (right before the zeros).
- `j` will point at the last element in `nums2`.
- `k` will point to the last element in `nums1` (the last zero).

Then, at each step, we compare the element at `nums1[i]` and `nums2[j]`. Since the arrays are sorted, these are the largest remaining values. Whichever is larger will be placed at `k`. We then decrement whichever index we used, and decrement `k` (the next spot to place the next largest element).

## Complexity

| Approach | Time | Space |
|---|---|---|
| Three Pointers | `O(m + n)` | `O(1)` |

## Notes
- The loop condition is set as `j >= 0` which ensures we consume all the elements of `nums2`. If there are more elements in `nums1` than in `nums2` after the loop runs, these will already be sorted. 
- If there are more elements in `nums2`, we have the `i >= 0`check in the if statement that ensures the else branch runs if there are no more valid elements from `nums1`.
 