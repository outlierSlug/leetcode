<!--
number: 0023
title: Merge k Sorted Lists
pattern: linked-list
difficulty: Hard
languages: Java
slug: merge-k-sorted-lists
last_reviewed: 2026-10-31
-->
# Merge k Sorted Lists
[Problem Description](https://leetcode.com/problems/merge-k-sorted-lists/description/)

Summary: Given an array of `k` linked lists, each sorted in ascending order, merge all the lists into one sorted linked list and return it.

## Algorithm
A min-heap holding the current front node of each list.

At every step of the merge, the next node in the output is the smallest among the current front nodes of the `k` lists. A min-heap keeps those candidates and returns the smallest in $O(\log k)$.

1. Create a min-heap of `ListNode`s ordered by `val`, using `Integer.compare(a.val, b.val)`.
2. Push the head of every non-empty list. `PriorityQueue` does not accept `null`, so empty lists are skipped.
3. Build the result with a `dummy` node and a `tail` pointer. While the heap is not empty:
   - Poll the smallest node and append it to `tail`.
   - If that node has a `next`, push it. The node's own `next` pointer acts as its list's cursor, so no separate pointer array is needed.
4. Return `dummy.next`.

## Complexity
Let `N` be the total number of nodes and `k` the number of lists.

| Approach | Time | Space |
|---|---|---|
| Min-Heap | $O(N \log k)$ | $O(k)$ |
| Divide and Conquer | $O(N \log k)$ | $O(\log k)$ |

The heap holds at most `k` nodes, and each of the `N` nodes is pushed and polled once. Strictly, the initial pass over `lists` adds $O(k)$, which only matters when most lists are empty.

## Notes
- `Integer.compare(a.val, b.val)` avoids potential overflow from `a.val - b.val`
- **Divide & Conquer Solution**: A recursive helper `mergeRange(lists, lo, hi)` returns `lists[lo]` when `lo == hi`, otherwise splits at `mid`, recursively merges each half into one list, and combines the two results with the two-list merge from [21](../0021-merge-two-sorted-lists/). There are $\log k$ levels, and every node takes part in exactly one merge per level, giving $O(N \log k)$ time and $O(\log k)$ recursion stack. 

```java
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        return mergeRange(lists, 0, lists.length - 1);
    }

    private ListNode mergeRange(ListNode[] lists, int lo, int hi) {
        // Base Case
        if (lo == hi) return lists[lo];

        // Divide & Conquer
        int mid = lo + (hi - lo) / 2;
        ListNode left = mergeRange(lists, lo, mid);
        ListNode right = mergeRange(lists, mid + 1, hi);

        // Combine the sorted left and right halves
        return mergeTwoLists(left, right);
    }

    // Merge Two Sorted Lists algorithm
    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        curr.next = (list1 != null) ? list1 : list2;
        return dummy.next;
    }
}
```

- An iterative bottom-up version, merging pairs at gaps 1, 2, 4, and so on, uses $O(1)$ extra space.