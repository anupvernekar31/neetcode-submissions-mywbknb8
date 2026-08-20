// ==========================
// MEMOIZATION APPROACH
// ==========================

/*class Solution {

    int coinChangeUtil(int ind, int amount, int[][] dp, int[] coins){
        if(ind == 0){
            if(amount%coins[ind] == 0){
                return amount/coins[ind];
            } else {
                return (int) Math.pow(10, 9);
            }
        }

        if(dp[ind][amount] !=-1){
            return dp[ind][amount];
        }
        int notTake = coinChangeUtil(ind-1, amount, dp, coins);
        int take = (int) Math.pow(10, 9);
        if(coins[ind]<=amount){
            take = 1+coinChangeUtil(ind, amount-coins[ind], dp, coins);
        }

        return dp[ind][amount] = Math.min(take, notTake);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];

        for(int i=0;i<n;i++){
            Arrays.fill(dp[i], -1);
        }
        int ans = coinChangeUtil(n-1, amount, dp, coins);
        if (ans >= (int) Math.pow(10, 9))
            return -1;
        return ans;
    }
}*/

// ==========================
// TABULATION APPROACH
// ==========================

class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int INF = (int) 1e9;
        int[][] dp = new int[n][amount + 1];

        // Base case: use only coins[0]
        for (int target = 0; target <= amount; target++) {
            if (target % coins[0] == 0) {
                dp[0][target] = target / coins[0];
            } else {
                dp[0][target] = INF;
            }
        }

        // Fill remaining rows
        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= amount; target++) {

                // Do not take current coin
                int notTake = dp[ind - 1][target];

                // Take current coin (same row: unlimited use)
                int take = INF;
                if (coins[ind] <= target) {
                    take = 1 + dp[ind][target - coins[ind]];
                }

                dp[ind][target] = Math.min(take, notTake);
            }
        }

        int ans = dp[n - 1][amount];
        return ans >= INF ? -1 : ans;
    }
}