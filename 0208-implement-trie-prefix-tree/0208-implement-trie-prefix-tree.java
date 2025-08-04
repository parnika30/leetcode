class Trie {
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

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node node = root;
        for(int i =0; i<word.length(); i++){
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i), new Node());
            }
            //move to the new reference
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        Node node = root;
        for(int i =0; i<word.length(); i++){
            if(!node.containsKey(word.charAt(i))){
               return false;
            }
            //move to the new reference
            node = node.get(word.charAt(i));
        }
        if(node.isEnd()) return true;
        return false;
    }
    
    public boolean startsWith(String prefix) {
        Node node = root;
        for(int i =0; i<prefix.length(); i++){
            if(!node.containsKey(prefix.charAt(i))){
               return false;
            }
            //move to the new reference
            node = node.get(prefix.charAt(i));
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */