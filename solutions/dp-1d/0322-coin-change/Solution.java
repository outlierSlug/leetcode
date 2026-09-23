import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        // Let dp(a) be the minimum number of coins needed 
        // to make an amount a. 
        // dp(0) = 0
        // dp(a) = min(dp(a), 1 + dp(a - coin))
        int[] dp = new int[amount + 1];

        // Set every value in dp[] to a sentinal value representing "impossible".
        // The maximum number of coins for any amount is amount (if there is a 1 coin).
        // Thus, we can set (amount + 1) as this sentinal value.
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int a = 1; a <= amount; a++) {
            for (int coin : coins) {
                if (coin > a) continue;  // coin value is larger than the current amount a, skip it
                dp[a] = Math.min(dp[a], 1 + dp[a - coin]);    
            }
        }

        // If dp[amount] has a valid min count, return that count stored in dp[amount]. Otherwise, no valid count was found,
        // and dp[amount] still contains a sentinal value larger than the max possible count (amount). Return -1.
        return dp[amount] > amount ? -1 : dp[amount];
    }
}