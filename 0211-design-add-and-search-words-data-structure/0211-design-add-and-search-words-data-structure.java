class WordDictionary {

    class Node{
        Node[] nodes = new Node[26]; 
        boolean flag = false;

        Node(){}

        boolean containsKey(char c){
            if(nodes[c - 'a'] != null) return true;
            return false;
        }

        Node get(char c){
            return nodes[c-'a'];
        }

        void put(char c, Node node){
            nodes[c - 'a'] = node;
        }

        void setEnd(){
            flag = true;
        }

        boolean isEnd(){
            return flag;
        }
    }

    Node root; 

    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node node = root; 
        for(int i =0; i<word.length(); i++){
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        Node node = root;
        return dfs(0, node, word);
    } 

    private boolean dfs(int ind, Node node, String word){
        if(ind == word.length()) return node.isEnd();
        char c = word.charAt(ind);
            if(c == '.'){
                for(Node n : node.nodes){
                    if(n != null && dfs(ind+1, n, word)) return true;
                }
                return false;
            }else{
                if(!node.containsKey(word.charAt(ind))){
                    return false;
                }return dfs(ind+1, node.get(c), word);
            }
    } 
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */