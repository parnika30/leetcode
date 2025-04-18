//tle -> 2^n
// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;
//         return recursion(n-1, nums);
//     }

//     private int recursion(int index, int[] nums){
//         if(index < 0) return 0 ;
//         if(index == 0) return nums[index];

//         int pick = nums[index] + recursion(index-2, nums);
//         int notPick = 0 + recursion(index-1, nums);
//         return Math.max(pick, notPick);
//     }
// }

//memoization
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return recursion(n-1, nums, dp);
    }

    private int recursion(int index, int[] nums, int[] dp){
        if(index < 0) return 0 ;
        if(index == 0) return nums[index];
        if(dp[index]!=-1) return dp[index];

        int pick = nums[index] + recursion(index-2, nums, dp);
        int notPick = 0 + recursion(index-1, nums,dp);
        return dp[index] = Math.max(pick, notPick); //initialized the value
    }
}