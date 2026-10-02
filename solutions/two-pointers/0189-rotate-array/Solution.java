class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        // 1. Reverse the entire array
        reverse(nums, 0, n - 1);

        // 2. Reverse the first partition of k numbers
        reverse(nums, 0, k - 1);

        // 3. Reverse the second partition of n - k numbers
        reverse(nums, k, n - 1);
    }

    // Reverses the given subarray from [l, r].
    private void reverse(int[] arr, int l, int r) {
        while (l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}