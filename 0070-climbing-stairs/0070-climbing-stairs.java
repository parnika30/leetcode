// class Solution {
//     HashMap <Integer,Integer> hs = new HashMap<>();
//     public int climbStairs(int n) {
//         if(n == 0 || n == 1) return 1;
//         if (hs.containsKey(n)) return hs.get(n);
//         int res = climbStairs(n-1) + climbStairs(n-2); 
//         hs.put(n,res);
//         return res; 
//     }

// }


class Solution {
    public int climbStairs(int n) {
        if(n == 0 || n == 1) return 1;
        return climbStairs(n-1) +  climbStairs(n-2);
    }
}