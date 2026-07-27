class Solution {
    public int maxProfit(int[] prices) {
        int MaxProfit = 0, mini = prices[0];

        for(int i=0;i<prices.length;i++){
            int cost = prices[i] - mini;
            MaxProfit = Math.max(MaxProfit, cost);
            mini = Math.min(prices[i], mini);
        }

        return MaxProfit;
        
    }
}
