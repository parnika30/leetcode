class Solution {
    public int change(int amount, int[] coins) {

        int n = coins.length;
        int[][] dp = new int[n][amount+1];

        for(int i=0;i<n;i++){
            for(int j=0;j<=amount;j++){
                dp[i][j] = -1;
            }
        }
        
        return rec(n-1, amount, coins, dp);
    }
    
    private int rec(int ind, int sum, int[] arr, int [][] dp){
        if(ind==0){
            if(sum % arr[ind] == 0) return 1;
            else return 0;
        }
        
        if(dp[ind][sum] != -1) return dp[ind][sum];
        int not = rec(ind-1, sum, arr, dp);
        int take = 0;
        if(arr[ind] <= sum){
            take = rec(ind, sum-arr[ind], arr, dp); 
            // key diff is, when we can repeat elemts, we will stay at the same ind and not ind-1
        }
        
        return dp[ind][sum] = not + take;
        
    }
    
}