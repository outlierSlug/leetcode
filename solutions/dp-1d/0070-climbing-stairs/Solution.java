class Solution {
    public int climbStairs(int n) {
        // Let dp[n] = the number of distinct moves to reach the n-th step.
        // dp[1] = 1; dp[2] = 2
        // dp[n] = dp[n-1] + dp[n-2] for n > 2
        if (n == 1) return 1;
        if (n == 2) return 2;
        
        int[] dp = new int[n + 1];
        dp[1] = 1; 
        dp[2] = 2;
        
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}