class Solution {
    public int findPeakElement(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                hi = mid - 1;
            } else if (mid < nums.length - 1 && nums[mid] < nums[mid + 1]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;  // should never reach here
    }
}