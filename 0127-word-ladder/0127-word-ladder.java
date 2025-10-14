class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<String> queue = new LinkedList<>();
        Set<String> words = new HashSet<>(wordList);
        words.remove(beginWord);

        queue.add(beginWord);
        int level = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            level++;
            for(int i=0;i<size;i++){
                String currentWord = queue.poll();
                if(currentWord.equals(endWord)) return level;

                List<String> neighbours = neighbours(currentWord);
                for(String s : neighbours){
                    if(words.contains(s)){
                        words.remove(s);
                        queue.add(s);
                    }
                }
            }
        }
        return 0;
        
    }

    private List<String> neighbours(String str){
        List<String> neighbours = new ArrayList<>();
        char[] chars = str.toCharArray();

        for(int i = 0; i<chars.length; i++){
            char og = chars[i];

            for(char c='a'; c<='z'; c++){
                if(c==og) continue;
                chars[i] = c; 
                String newWord = new String(chars);
                neighbours.add(newWord);
            }
            chars[i] = og;
        }
        return neighbours;
    }
}