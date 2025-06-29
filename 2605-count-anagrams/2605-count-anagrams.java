class Solution {
        static final int MOD = 1_000_000_007;
        static final int MAX = 100005;
        static long[] fact = new long[MAX];
        static long[] invFact = new long[MAX];


        static {
            fact[0] = invFact[0] = 1;
            for(int i =1; i<MAX; i++){
                fact[i] = (fact[i-1] * i) % MOD;
                invFact[i] = pow(fact[i], MOD-2);
            }
        }

        static long pow(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) != 0) res = (res * a) % MOD;
            a = (a * a) % MOD;
           b >>= 1;
        }
        return res;
    }

    public int countAnagrams(String s) {
        long res = 1;

        for(String word : s.split(" ")){
            int[] freq = new int[26];
            for(char c : word.toCharArray()){
                freq[c-'a']++;
            }
            long denom = 1;
            for(int f : freq){
                if(f > 1) denom = (denom * invFact[f]) % MOD;
            }
            res = (res * fact[word.length()] % MOD * denom % MOD) % MOD;

        }
        return (int) res;
    }
}

//calculating : 
//fact[word.length()] / (fact[freq[a]] * fact[freq[b]] * ...)
