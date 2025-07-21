//memoization - tc = O(n)
//sc - O(n)(extra for dp array) +  O(N)
class Solution{
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=amount;j++){
                dp[i][j] = -1;
            }
        }
    
        int ans = recursion(n-1, coins, amount, dp);
        if(ans >=  Integer.MAX_VALUE) return -1;
        else return ans;
    }

    private int recursion(int ind, int[] nums, int amount, int[][] dp){
        if(ind == 0){
            if(amount%nums[0] == 0) return amount/nums[0];
            return Integer.MAX_VALUE;
        }

        if(dp[ind][amount]!=-1) return dp[ind][amount];

        int pick = Integer.MAX_VALUE;
        int notPick = 0 + recursion(ind-1, nums,amount, dp);
        if(nums[ind] <= amount){
            pick = 1 + recursion(ind, nums, amount-nums[ind], dp);
            //coins will always be inc by 1. 
        }
        //return dp[index] = Math.min(pick, notPick); //initialized the value
        return dp[ind][amount] = Math.min(pick, notPick); 
    }
}