class Solution {
    public int countVowelSubstrings(String word) {
        int count = 0;
        HashSet<Character> hs = new HashSet<>();
        for(int i = 0; i < word.length(); i++){
            for(int j =i ; j<word.length(); j++){
                char ch = word.charAt(j);
                if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                    hs.add(ch);
                    if(hs.size() == 5) count++;
                }else{ 
                    break; 
                }
            }
            hs.clear();
        }
        return count;
    }
}