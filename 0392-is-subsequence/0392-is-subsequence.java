class Solution {
    public boolean isSubsequence(String s, String t) {
        int i =0, j =0;
        while(j<t.length() && i<s.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }
        if(i == s.length()) return true;
        return false;

    }
}