class Solution {
    public String reverseVowels(String s) {
        
        List<Character> vowels = Arrays.asList('a', 'e', 'i','o','u','A','E','I','O','U');
        char[] ch=s.toCharArray();  //[l,e,e,t,c,o,d,e]
        
        int start = 0;
        int end = ch.length-1;  
        
        while(start<end){
            if(vowels.contains(ch[start]) && vowels.contains(ch[end])){
                //swap
                char temp = ch[start];
                ch[start] = ch[end];
                ch[end] = temp;
                start++;end--;
            }
            else if(!vowels.contains(ch[start]) && vowels.contains(ch[end])){
                start++;
            }
            else if(vowels.contains(ch[start]) && !vowels.contains(ch[end])){
                end--;
            }
            else if(!vowels.contains(ch[start]) && !vowels.contains(ch[end])){
                start++;end--;
             }
        
        }
         return String.valueOf(ch);
    }
}