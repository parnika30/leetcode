class Solution {
    public int strStr(String haystack, String needle) {
        // for(int i =0, j=needle.length(); j<=haystack.length(); i++, j++){
        //     String sub = haystack.substring(i,j); 
        //     if(sub.equals(needle)) return i; 
        // }

        // return -1;


        if(haystack.contains(needle)){
            return haystack.indexOf(needle);
        }

        return -1; 
        
    }
}