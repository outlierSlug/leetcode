class Solution:
    def rotate(self, nums: list[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        k = k % n

        def reverse(arr, start, end):
            l, r = start, end
            while l < r:
                arr[l], arr[r] = arr[r], arr[l]
                l, r = l + 1, r - 1
        
        # 1. Reverse the entire array
        reverse(nums, 0, n - 1)

        # 2. Reverse the first partition of k numbers
        reverse(nums, 0, k - 1)
        
        # 3. Reverse the second partition of n - k numbers
        reverse(nums, k, n - 1)