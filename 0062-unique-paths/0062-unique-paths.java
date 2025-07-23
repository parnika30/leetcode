// class Solution {
//     public int uniquePaths(int m, int n) {
//         int[][] dp = new int[m][n];
//         for(int i=0;i<m;i++){
//             for(int j=0;j<n;j++){
//                 dp[i][j] = -1;
//             }
//         }

//         return rec(m-1, n-1, dp);
//     }

//     private int rec(int m, int n, int[][] dp){
//         if(m==0 && n==0) return 1;
//         if(m<0 || n<0){
//             return 0;
//         }

//         if(dp[m][n]!=-1) return dp[m][n];

//         int down = rec(m-1,n, dp);
//         int right = rec(m, n-1, dp);

//         return dp[m][n] = down + right;

//     }
// }


//mem -> tab : declare base case, express states of r/c in for loop

class Solution {
    public int uniquePaths(int m, int n) {
        if(m==0 && n==0) return 1;
        if(m<0 || n<0){
            return 0;
        }

        int[][] dp = new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                
                int down = 0, right = 0;
                if(i==0 && j == 0) dp[i][j] = 1;
                else{
                    if(i > 0) down = dp[i-1][j];
                    if(j>0) right = dp[i][j-1];

                    dp[i][j] = down + right;
                }
            }
        }

        return dp[m-1][n-1];
    }
}