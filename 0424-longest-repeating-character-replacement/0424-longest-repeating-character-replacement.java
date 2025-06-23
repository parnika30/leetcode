class Solution {
    public int characterReplacement(String s, int k) {
        int i=0;
        int maxFreq = 0;
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int j=0;j<s.length(); j++){
            char curr = s.charAt(j);
            map.put(curr,map.getOrDefault(curr,0)+1);

            int freq = map.get(curr);
            maxFreq = Math.max(maxFreq,freq);
            
            while(j-i+1 - maxFreq >  k){
                char left = s.charAt(i++);
                map.put(left, map.get(left) - 1); //reduce the freq of left 
            }
            maxLen = Math.max(maxLen, j-i+1);
        }
        return maxLen;
    }
}