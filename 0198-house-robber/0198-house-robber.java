// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;
//         return recursion(nums,n-1);
//     }

//     private int recursion(int[] nums, int index){
//         if(index == 0)return nums[index];
//         if(index < 0)return 0;

//         int pick = nums[index] + recursion(nums, index-2);
//         int notPick = 0 + recursion(nums, index-1);

//         return Math.max(pick, notPick);

//     }
// }

//recursive approach 

//dp
// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;
//         int[] dp = new int[n];
//         Arrays.fill(dp,-1);
//         return recursion(nums,n-1, dp);
//     }

//     private int recursion(int[] nums, int index, int[] dp){
//         if(index == 0)return nums[index];
//         if(index < 0)return 0;
//         if(dp[index] != -1) return dp[index];

//         int pick = nums[index] + recursion(nums, index-2, dp);
//         int notPick = 0 + recursion(nums, index-1, dp);

//         return dp[index] =  Math.max(pick, notPick);
//     }
// }


// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;
//         if(n==0) return 0;
//         if(n==1) return nums[0];
        
//         int[] dp = new int[n];
//         dp[0] = nums[0];
//         dp[1] = Math.max(nums[0],nums[1]);

//         for(int i = 2; i<n;i++){
//             int take = nums[i] + dp[i-2];
//             int leave = 0+dp[i-1];
//             dp[i] = Math.max(take,leave);
//         }
//         return dp[n-1];
//     }
// }

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        int prev = nums[0];
        int prev2 = 0;

        for(int i = 1; i<n;i++){
            int take = nums[i];
            if(i > 1){
                take = take + prev2;
            }
            int leave = 0+prev;
            int curr = Math.max(take,leave);
            prev2 = prev;
            prev = curr;    
        }
        return prev;
    }
}
