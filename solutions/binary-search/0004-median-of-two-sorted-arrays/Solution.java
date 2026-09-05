class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Binary search over the smaller array, guarantess O(log(min(m, n))) runtime.
        if (nums2.length < nums1.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        // m <= n
        int m = nums1.length;
        int n = nums2.length;

        int lo = 0;
        int hi = m;

        // Total elements in the combined left half partition.
        // Any "extra" element in an odd total element case is sent to the leftHalf.
        int leftHalf = (m + n + 1) / 2; 

        while (lo <= hi) {
            // i = how many elements from nums1 go in the leftHalf partition.
            // j = leftHalf - i, i.e. the remaining elements needed for leftHalf need to come from nums2.
            int i = lo + (hi - lo) / 2;
            int j = leftHalf - i;

            // Boundary elements: Sentinal values ensure edge cases remain valid.
            int nums1Left = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int nums1Right = (i == m) ? Integer.MAX_VALUE : nums1[i];
            int nums2Left = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int nums2Right = (j == n) ? Integer.MAX_VALUE : nums2[j];
            
            // If the left boundaries are both <= the other array's respective right boundary, we have a valid partition.
            if (nums1Left <= nums2Right && nums2Left <= nums1Right) {
                // If the total number of combined elements is even, return the average of the largest left boundary + smallest right boundary.
                // Otherwise, if the total number is odd, return the largest left boundary (the "extra" element is part of leftHalf)
                if ((m + n) % 2 == 0) {
                    return (Math.max(nums1Left, nums2Left) + Math.min(nums1Right, nums2Right)) / 2.0;
                } else {
                    return Math.max(nums1Left, nums2Left);
                }
            } else if (nums1Left > nums2Right) {
                // nums1Left is too high, shrink the nums1 cut.
                hi = i - 1;
            } else {
                // nums1Left is too low, widen the nums1 cut.
                lo = i + 1;
            }
        }
        return -1;  // unreachable given valid, non-empty, non-null arrays.
    }
}