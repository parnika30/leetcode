//extension of longest Common Subsequence
// 1. reverse the string. now when we find common subseq, we know it's a palindrome. 
//2. find common subsequence 

class Solution {
    private int longestCommonSubsequence(String text1, String text2) {
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

    public Integer longestPalindromeSubseq(String s) {
        StringBuilder sb = new StringBuilder(s);
        StringBuilder reversedString = sb.reverse();
        String t = reversedString.toString();
        return longestCommonSubsequence(s,t);
    }
}