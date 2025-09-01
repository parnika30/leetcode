// class Solution {
//     public int numDecodings(String s) { //"12"
//         if(s.length()==0) return 0;  //2
//         return ways(0,s);  
//     }

//     private int ways(int ind, String s){ //0,"12"
//         int n = s.length(); //n = 2
//         if(ind == n) return 1; 
//         if(s.charAt(ind) == '0') return 0;

//         int res = ways(ind+1, s); 
        
//         // 1. ways(1,"12")-> res = 1
//         //if(pass) {res = 1+ways(2, "12")}

//         if(ind < n-1 && (s.charAt(ind) == '1' || s.charAt(ind) == '2' && s.charAt(ind+1) < '7')){
//             res += ways(ind+2, s); 
//         }
//         return res; 
//     }
// }

//mem -> tc & sc = O(n)
// class Solution {
//     public int numDecodings(String s) { //"12"
//         int[] dp = new int[s.length()];
//         Arrays.fill(dp, -1);
//         if(s.length()==0) return 0;  //2
//         return ways(0,s,dp);  
//     }

//     private int ways(int ind, String s, int[] dp){ //0,"12"
//         int n = s.length(); //n = 2
//         if(ind == n) return 1; 
//         if(s.charAt(ind) == '0') return 0;

//         if(dp[ind]!= -1) return dp[ind];
//         int res = ways(ind+1, s, dp); 
        
//         if(ind < n-1 && (s.charAt(ind) == '1' || s.charAt(ind) == '2' && s.charAt(ind+1) < '7')){
//             res += ways(ind+2, s, dp); 
//         }
//         return dp[ind] = res; 
//     }
// }


//tc = O(n) & sc is O(1)
class Solution {
    public int numDecodings(String s) { //"12"
        int curr = 1, next = 0, n = s.length();  
        for(int i=n-1; i>=0; i--){ 
            int temp = 0;
            if(s.charAt(i) == '0') temp = 0;
            else temp = curr;

            if(i < n-1 && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i+1) < '7')){
                temp += next; 
            }
            next = curr;
            curr = temp;
        }
        return curr;

    }
}