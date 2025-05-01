//memoized vesion
class Solution {
    private int recursion(String text1, String text2, int n, int m, int[][] dp){
        if(n<0 || m < 0) return 0;
        if(dp[n][m] !=-1) return dp[n][m];
        if(text1.charAt(n) == text2.charAt(m)){
            return dp[n][m] = 1 + recursion(text1, text2, n-1,m-1, dp);
        }else{
            return dp[n][m] = Math.max(recursion(text1, text2, n,m-1, dp), recursion(text1, text2, n-1,m,dp));
        }
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }   
        return recursion(text1, text2, n-1,m-1, dp);
    }
}