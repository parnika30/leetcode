class Solution {
    public int countCharacters(String[] words, String chars) {
        int sum = 0;

        HashMap<Character,Integer> charMap = new HashMap<>();
        for(char c : chars.toCharArray()){
            charMap.put(c, charMap.getOrDefault(c,0)+1);
        }

        for(int i=0;i<words.length;i++){
            HashMap<Character,Integer> wordMap = new HashMap<>();
            for(char c : words[i].toCharArray()){
                wordMap.put(c, wordMap.getOrDefault(c,0)+1);
            }

            boolean canForm = true;
            for (char key : wordMap.keySet()) {
                if (wordMap.get(key) > charMap.getOrDefault(key, 0)) {
                    canForm = false;
                }
            }

            if(canForm){
                sum += words[i].length();
            }
        }

        return sum;
    }
}

// a:2, t:1, c:1, h:1 
// c:1, a:1, t:1 

// for(each word in string arry){
//     map.put(char freq)
// }

// put chars in map => charMap 
// keyset in charMap{
//     if(f >= map.get()) list.add(entry)
// }