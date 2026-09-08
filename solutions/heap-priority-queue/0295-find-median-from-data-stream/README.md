<!--
number: 0295
title: Find Median from Data Stream
pattern: heap-priority-queue
difficulty: Hard
languages: Java
slug: find-median-from-data-stream
last_reviewed: 2026-09-07
-->
# Find Median from Data Stream
[Problem Description](https://leetcode.com/problems/find-median-from-data-stream/description/)

Summary: Design a data structure supporting `addNum(int num)` and `findMedian()`, maintaining the median of all numbers seen so far as they arrive one at a time.

## Algorithm
We will split all numbers seen so far into two balanced halves using two heaps:
- `maxHeap`: holds the smaller half, so its top is the largest of the small half.
- `minHeap`: holds the larger half, so its top is the smallest of the large half.

Maintain two invariants after every `addNum` call: 
1. The two heaps differ in size by at most 1,
2. `maxHeap`'s top is always `<= minHeap`'s top. 

Together, these mean the two heaps' tops are always the elements immediately straddling the middle of the sorted order.

**`addNum(int num)`:** always insert the new number into `maxHeap` (the left half) first, then run three corrective checks:
1. If `maxHeap`'s top now exceeds `minHeap`'s top, move `maxHeap`'s top into `minHeap` (fixes ordering).
2. If `maxHeap` has grown *more than 1* larger than `minHeap`, move `maxHeap`'s top into `minHeap` (fixes size balance).
3. Symmetric check the other direction, in case `minHeap` becomes too large.

Since both heaps start balanced before the call, and exactly one new element is introduced, at most one corrective move is ever needed per check, i.e. a single pass through the three checks (not a loop) is always sufficient to restore both invariants.

**`findMedian()`:** if the heaps are equal size (even total count), the median is the average of both tops. If one heap has one extra element (odd total count), the median is that heap's top.

## Complexity

| Operation | Time | Space |
|---|---|---|
| `addNum` | `O(log n)` | `O(n)` |
| `findMedian` | `O(1)` | - |

## Notes
- Always inserting into `maxHeap` first (rather than trying to decide up front which heap a number "belongs" in) works because the corrective checks afterward always restore both invariants regardless of where the number initially landed.
