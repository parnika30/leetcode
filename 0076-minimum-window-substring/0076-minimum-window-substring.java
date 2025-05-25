class Solution {
    private boolean isValid(HashMap<Character, Integer> hsS, HashMap<Character, Integer>hsT){
        for(Map.Entry<Character, Integer> entry : hsT.entrySet()){
            char comp = entry.getKey();
            if(hsS.getOrDefault(comp, 0) < entry.getValue()){
                return false;
            }
        }
        return true;
    }
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> hsT = new HashMap<>();
        HashMap<Character, Integer> hsS = new HashMap<>();
        int n = s.length();
        int start = 0, end =0; 
        int min = Integer.MAX_VALUE;
        int minStart = 0;

        for(int i = 0;i<t.length();i++){
            hsT.put(t.charAt(i), hsT.getOrDefault(t.charAt(i),0)+1);
        }

        while(end<n){
            //hsT and hsS comparing logic for window ? 
            hsS.put(s.charAt(end), hsS.getOrDefault(s.charAt(end),0)+1);

            //valid window
            while(isValid(hsS, hsT)){
                if(end-start + 1 < min){
                    min = end-start + 1;
                    minStart = start;
                }
                //shrink window
                char left = s.charAt(start);
                hsS.put(left, hsS.get(left)-1);
                start++;
            }
            end++;
        }

        if(min == Integer.MAX_VALUE){
            return "";
        }else{
            return s.substring(minStart, minStart + min);
        }
    }
}