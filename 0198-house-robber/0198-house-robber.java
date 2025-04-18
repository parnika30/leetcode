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

//memoization - tc = O(n)
// sc - O(n)(extra for dp array) +  O(N)
// class Solution 
//     public int rob(int[] nums) {
//         int n = nums.length;
//         int[] dp = new int[n];
//         Arrays.fill(dp,-1);
//         return recursion(n-1, nums, dp);
//     }

//     private int recursion(int index, int[] nums, int[] dp){
//         if(index < 0) return 0 ;
//         if(index == 0) return nums[index];
//         if(dp[index]!=-1) return dp[index];

//         int pick = nums[index] + recursion(index-2, nums, dp);
//         int notPick = 0 + recursion(index-1, nums,dp);
//         return dp[index] = Math.max(pick, notPick); //initialized the value
//     }
// }

//auxilary space of dp array O(n) is used.
// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;
//         if (n == 0) return 0;
//         if (n == 1) return nums[0];

//         int[] dp = new int[n];
//         dp[0] = nums[0];
//         dp[1] = Math.max(nums[0], nums[1]);

//         for (int i =2 ;i<n;i++){
//             int take = nums[i] + dp[i-2];
//             int leave = 0+dp[i-1];
//             dp[i] = Math.max(take,leave);
//         }
//         return dp[n-1];
//     }
// }


//no auxilary space of dp.
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int prev = nums[0];
        int prev2 = 0;
        for (int i =1 ;i<n;i++){
            int take = nums[i];
            if(i>1) take += prev2;
            int leave = 0+prev;

            int curr = Math.max(take,leave);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}