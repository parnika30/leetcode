//recursion - tle
// class Solution {
//     public int minCostClimbingStairs(int[] cost) {
//         int n = cost.length;
//         return Math.min(minCost(cost, n-1), minCost(cost, n-2));
//     }

//     private int minCost(int[] cost, int n){
//         if(n==0 || n==1) return cost[n];
//         return cost[n] + Math.min(minCost(cost, n-1), minCost(cost, n-2));
//     }
// }

// //dp - memoization 
// class Solution {
//     public int minCostClimbingStairs(int[] cost) {
//         int n = cost.length;
//         int[] dp = new int[n];
//         for(int i=0; i<n;i++){
//             if(i<2) dp[i] = cost[i];
//             else dp[i] = cost[i] + Math.min(dp[i-2], dp[i-1]);
//         }
//         return Math.min(dp[n-2], dp[n-1]);
//     }
// }


class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int prev2 = cost[0];
        int prev = cost[1]; 
        if(n<2) return Math.min(prev2, prev);

        int curr = 0; 
        for(int i =2;i <n ;i++){
            curr = cost[i] + Math.min(prev2, prev); ;
            prev2 = prev;
            prev = curr; 
        }
        return Math.min(prev2, prev);
    }
}//dp - tabulation  

