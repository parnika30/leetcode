class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int i=0,j=0,len=Integer.MIN_VALUE;
        if(s.length() == 0)return 0;
        while(j<s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                len = Math.max(len, j-i+1);
                j++;
            }else{
                set.remove(s.charAt(i));
                i++;   
            }
        }
        return len;
    }
}