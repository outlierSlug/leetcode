class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = binSearch(nums, target, true);
        int right = binSearch(nums, target, false);
        return new int[]{left, right};
    }

    private int binSearch(int[] nums, int target, boolean leftBias) {
        int lo = 0;
        int hi = nums.length - 1;
        int result = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                result = mid;
                if (leftBias) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return result;
    }
}