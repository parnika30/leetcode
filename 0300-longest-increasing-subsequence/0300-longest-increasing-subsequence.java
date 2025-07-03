class Solution {
    private int lis(int[] nums, int n, int curr, int prev, int[][] dp) {
        if(curr == n) return 0;
        if(dp[curr][prev+1] != -1)return dp[curr][prev+1]; 

        //not pick
        int len = 0 + lis(nums, n, curr+1, prev, dp);

        //pick
        if(prev == -1 || nums[curr] > nums[prev]){
            len = Math.max(len, 1 + lis(nums, n, curr+1, curr, dp));
        }

        return dp[curr][prev+1] = len;
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length; 
        int[][] dp = new int[n][n+1];

        for(int i=0;i<n;i++){
            for(int j=0; j<n; j++){
                dp[i][j] = -1;
            }
        }
        return lis(nums,n, 0, -1, dp); 
        //0 : currInd, -1: prevInd
    }
}