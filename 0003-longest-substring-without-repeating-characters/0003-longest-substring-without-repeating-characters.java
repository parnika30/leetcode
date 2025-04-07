class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs = new HashSet<>();
        int max = 0;
        int left = 0;
        for(int right = left; right<s.length();right++){
            if(!hs.contains(s.charAt(right))){
                hs.add(s.charAt(right));
                max = Math.max(max, right-left+1);
            }else{
                while(s.charAt(right)!=s.charAt(left)){
                    hs.remove(s.charAt(left));
                    left++;
                }
                hs.remove(s.charAt(left));
                left++;
                hs.add(s.charAt(right));
            }
        }
        return max;
    }
}