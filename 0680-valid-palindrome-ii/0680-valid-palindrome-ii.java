class Solution {
    public boolean validPalindrome(String s) {
        if(s.length() == 1 || s.length()==0 || s.length()==2)return true;
        int l=0, r = s.length()-1;
        while(l<r){
            if(s.charAt(l) == s.charAt(r)){
                l++;
                r--;
            }
            else {
                return isPalindrome(s.substring(l, r)) || isPalindrome(s.substring(l + 1, r + 1));
            }
        }
        return true;
        
    }

    private static boolean isPalindrome(String str){
        int l = 0;
        int h = str.length()-1;
        while(l<h){
            if(str.charAt(l) != str.charAt(h)){
                return false;
            }
            l++;
            h--;
        }
        return true;

    }
}