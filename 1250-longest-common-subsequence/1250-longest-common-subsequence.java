//memoized vesion
// class Solution {
//     private int recursion(String text1, String text2, int n, int m, int[][] dp){
//         if(n<0 || m < 0) return 0;
//         if(dp[n][m] !=-1) return dp[n][m];
//         if(text1.charAt(n) == text2.charAt(m)){
//             return dp[n][m] = 1 + recursion(text1, text2, n-1,m-1, dp);
//         }else{
//             return dp[n][m] = Math.max(recursion(text1, text2, n,m-1, dp), recursion(text1, text2, n-1,m,dp));
//         }
//     }

//     public int longestCommonSubsequence(String text1, String text2) {
//         int n = text1.length(), m = text2.length();
//         int[][] dp = new int[n][m];

//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {
//                 dp[i][j] = -1;
//             }
//         }   
//         return recursion(text1, text2, n-1,m-1, dp);
//     }
// }

//using top-down tabulation 
//shifting of indexes -> n-1 = n, n<0 => n==0
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        int[][] dp = new int[n+1][m+1];  

        //base case : If either string is empty, the LCS is 0.
        for (int i = 0; i <= n; i++) dp[i][0] = 0;
        for (int j = 0; j <= m; j++) dp[0][j] = 0;
 
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    //1 addeded becuase the min length will be 1, 
                    //if we find a matching string
                   dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    //Ignoring text1[i-1] → dp[i-1][j]
                    //Ignoring text2[j-1] → dp[i][j-1]
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            } 
        }
        return dp[n][m];
    }  
}
