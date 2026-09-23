import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {
        // Let dp(i) be the length of the longest increasing subsequence ending at nums[i].
        int[] dp = new int[nums.length];

        // Every individual number is trivially a LIS of 1.
        Arrays.fill(dp, 1);

        // Consider some index 0 <= j < i, with nums[j] < nums[i].
        // dp[i] = max(dp[i], 1 + dp[j]), i.e. take the max of 1 + any LIS prior to this index. 
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }
        
        // Return the max value of dp[].
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }
}