//extension of longest Common Subsequence
// 1. reverse the string. now when we find common subseq, we know it's a palindrome. 
//2. find common subsequence 

// class Solution {
//     private int longestCommonSubsequence(String text1, String text2) {
//         int n = text1.length(), m = text2.length();
//         int[][] dp = new int[n+1][m+1];  

//         //base case : If either string is empty, the LCS is 0.
//         for (int i = 0; i <= n; i++) dp[i][0] = 0;
//         for (int j = 0; j <= m; j++) dp[0][j] = 0;
 
//         for (int i = 1; i <= n; i++) {
//             for (int j = 1; j <= m; j++) {
//                 if(text1.charAt(i-1) == text2.charAt(j-1)){
//                     //1 addeded becuase the min length will be 1, 
//                     //if we find a matching string
//                    dp[i][j] = 1 + dp[i-1][j-1];
//                 }else{
//                     //Ignoring text1[i-1] → dp[i-1][j]
//                     //Ignoring text2[j-1] → dp[i][j-1]
//                     dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
//                 }
//             } 
//         }
//         return dp[n][m];
//     }  

//     public String longestPalindrome(String s) {
//         StringBuilder sb = new StringBuilder(s);
//         StringBuilder reversedString = sb.reverse();
//         String t = reversedString.toString();
//         return longestCommonSubsequence(s,t);
//     }
// }

class Solution{
    String res = "";
    int resLen = 0;
    public String longestPalindrome(String s) {

        for(int i =0; i< s.length(); i++){
            //check palindromes with odd lengths, int l = i, r = i
            //same point se start krke, left & right mei equally proceed karo
            computeSubstring(i,i,s);

            //check palindromes with even lengths, int l = i, r = i+1
            computeSubstring(i,i+1,s);
        }
        return res;
    }

    private void computeSubstring(int l, int r, String s){
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            if(r-l+1 > resLen) { //computes the length of substring palindrome
                resLen = r-l+1;
                res =  s.substring(l,r+1);
            }
            l--;r++;
        }
    }
}