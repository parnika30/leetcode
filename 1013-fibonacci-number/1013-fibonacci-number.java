//recursion 
// class Solution {
//     public int fib(int n) {
//         if(n<=1) {return n;}
//         else{return (fib(n-1) + fib(n-2));}
//     }
// }

//dp
class Solution {
    private int dpFib(int[] dp, int n){
        if(n<=1) return n;
        if(dp[n] != -1) return dp[n]; 
        //if not -1, dp array will have some value, that means, value is stored for that recursion. 
        return (dpFib(dp, n-1) + dpFib(dp, n-2));
    }
    public int fib(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return dpFib(dp, n);
    }
}