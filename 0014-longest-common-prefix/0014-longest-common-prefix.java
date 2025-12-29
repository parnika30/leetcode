class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)return "";
        int min = Integer.MAX_VALUE;
        for(String s : strs){
            min = Math.min(min,s.length());
        }

        int l=1,h=min;
        while(l<=h){
            int m = (l+h)/2;
            if(isCommonPrefix(strs,m)){
                l = m + 1;
            }else{
                h = m - 1;
            }
        }
        return strs[0].substring(0,(l+h)/2);
    }

    private boolean isCommonPrefix(String[] strs, int len){
        String str1 = strs[0].substring(0,len); //flo
        for(int i=1;i<strs.length;i++){
            if(!strs[i].startsWith(str1)) return false;
        }
        return true;
    }
}