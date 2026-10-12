class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;

        // Find the pivot point: First decreasing element starting from the end of nums
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // If a pivot exists, find the rightmost element just larger than it
        if (i >= 0) {
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        // Reverse the suffix to minimize it. If there was no pivot, this reverses the whole array.
        reverse(nums, i + 1);
    }

    // Swaps the two values at indices i and j.
    private void swap(int[] nums, int i , int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Reverses the suffix of the array nums beginning at index start.
    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}