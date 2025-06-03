class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            int left = i, right = i;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                res += 1;
                left--;
                right++;
            }
        } //odd length palindromes

        for(int i = 0; i < s.length(); i++){
            int left = i, right = i + 1;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                res += 1;
                left--;
                right++;
            } // even length palindromes
        }

        return res;
    }
}


//O(n^2) => ntimes checking for n length