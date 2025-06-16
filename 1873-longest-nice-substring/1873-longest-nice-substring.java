//O(n^3): 
// class Solution {
//     public String longestNiceSubstring(String s) {
//         String res = "";
//         for(int i =0; i< s.length(); i++){
//             for(int j= i+1; j<= s.length(); j++){
//                 String sub = s.substring(i,j);
//                 HashSet <Character> upper = new HashSet<>();
//                 HashSet <Character> lower = new HashSet<>();

//                 for(char c : sub.toCharArray()){
//                     if(Character.isLowerCase(c)) lower.add(c);
//                     else upper.add(c);
//                 }

//                 boolean nice = true;
//                 for(char c : sub.toCharArray()){
//                     if(!(upper.contains(Character.toUpperCase(c)) && 
//                     lower.contains(Character.toLowerCase(c)))) {
//                         nice = false;
//                         break;
//                     }
//                 }

//                 if(nice && sub.length() > res.length()){
//                     res = sub;
//                 }
//             }
//         }
//         return res;
        
//     }
// }


// O(N^2)
class Solution {
    public String longestNiceSubstring(String s) {
        if (s.length() < 2) return "";

        HashSet <Character> set = new HashSet<>();
        for(char c : s.toCharArray()){
            set.add(c);
        }

        for(int i =0; i<s.length(); i++){
            char c = s.charAt(i);
            if(set.contains(Character.toUpperCase(c)) && 
                set.contains(Character.toLowerCase(c))){
                    continue;
                }

            //DAC 
            String left = longestNiceSubstring(s.substring(0,i)); 
            String right = longestNiceSubstring(s.substring(i+1,s.length()));

            if(left.length() >= right.length()) return left;
            else return right;
        }
        return s;   
    }
}




