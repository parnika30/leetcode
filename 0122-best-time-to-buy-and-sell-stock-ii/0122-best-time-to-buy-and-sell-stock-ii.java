class Solution {
    private int calculate(int ind, int buy, int[] prices, int[][] dp){
        if(ind == prices.length) return 0;
        int profit = 0;
        if(dp[ind][buy] != -1) return dp[ind][buy];
        if(buy==1){
            profit = Math.max(
                (-prices[ind] + calculate(ind+1, 0, prices, dp)),
                                (0 + calculate(ind+1, 1, prices, dp))
                );
        }else{
            profit = Math.max((prices[ind] + calculate(ind+1, 1, prices, dp)),
                                (0 + calculate(ind+1, 0, prices, dp)));
        }
        return dp[ind][buy] = profit;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length; 
        int[][] dp = new int[n][2]; // n -> days , 2 -> (buy = 0 or 1)
        for(int i = 0; i< n ; i++){
            Arrays.fill(dp[i], -1);
        }
        return calculate(0,1,prices,dp);
    }
}