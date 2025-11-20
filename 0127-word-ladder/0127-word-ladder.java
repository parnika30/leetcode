class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<String> queue = new LinkedList<>();
        Set<String> words = new HashSet<>(wordList); //words : "hot","dot","dog","lot","log"
        words.remove(beginWord); 

        queue.add(beginWord); //q : hit
        int level = 0;

        while(!queue.isEmpty()){
            int size = queue.size(); //1
            level++; //1
            for(int i=0;i<size;i++){
                String currentWord = queue.poll(); //hit
                if(currentWord.equals(endWord)) return level;

                List<String> neighbours = neighbours(currentWord); //hit k neighbours
                for(String s : neighbours){ //ait
                    if(words.contains(s)){
                        words.remove(s);
                        queue.add(s);
                    }
                }
            }
        }
        return 0;
        
    }

    private List<String> neighbours(String str){ //hit
        List<String> neighbours = new ArrayList<>();
        char[] chars = str.toCharArray(); //h,i,t

        for(int i = 0; i<chars.length; i++){
            char og = chars[i]; //h

            for(char c='a'; c<='z'; c++){
                if(c==og) continue;
                chars[i] = c; //a
                String newWord = new String(chars);//ait
                neighbours.add(newWord);//ait-zit; not hit
            }
            chars[i] = og;//h
        }
        return neighbours;
    }
}