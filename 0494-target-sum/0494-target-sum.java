class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for(int i : nums){
            total+=i;
        }
        
        if(total - target < 0 || (total-target)%2 !=0) return 0;
        return findWays(nums, (total-target)/2);
        
    }
    
    private int findWays(int[] arr, int target){
        int n = arr.length;
        
        int[][] dp = new int[n][target+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=target;j++){
                dp[i][j] = -1;
            }
        }
        
        return rec(n-1, target, arr, dp);
    }
    
    private int rec(int ind, int sum, int[] arr, int [][] dp){
        if(ind==0){
            if(sum == 0 && arr[0] == 0) return 2;
            if(sum == 0 || sum == arr[0]) return 1;
        }
        if(ind<0){
            return 0;
        }
        
        if(dp[ind][sum] != -1) return dp[ind][sum];
        int not = rec(ind-1, sum, arr, dp);
        int take = 0;
        if(arr[ind] <= sum){
            take = rec(ind-1, sum-arr[ind], arr, dp);
        }
        
        return dp[ind][sum] = not + take;
        
    }
    
}