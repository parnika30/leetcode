class Solution {
    public String longestNiceSubstring(String s) {
        String res = "";
        for(int i =0; i< s.length(); i++){
            for(int j= i+1; j<= s.length(); j++){
                String sub = s.substring(i,j);
                HashSet <Character> upper = new HashSet<>();
                HashSet <Character> lower = new HashSet<>();

                for(char c : sub.toCharArray()){
                    if(Character.isLowerCase(c)) lower.add(c);
                    else upper.add(c);
                }

                boolean nice = true;
                for(char c : sub.toCharArray()){
                    if(!(upper.contains(Character.toUpperCase(c)) && 
                    lower.contains(Character.toLowerCase(c)))) {
                        nice = false;
                        break;
                    }
                }

                if(nice && sub.length() > res.length()){
                    res = sub;
                }
            }
        }
        return res;
        
    }
}