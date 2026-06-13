class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder ans = new StringBuilder();

        for(int i=0; i<words.length;i++){
            String word = words[i];
            int sum = 0;
            for(int j=0;j<word.length();j++){
                char c = word.charAt(j); //a
                sum += weights[c - 'a']; 
            }

            int target = sum%26;
            
            char newchar = (char)('z' - target);
            ans.append(newchar);
        }

        return ans.toString();
    }
}