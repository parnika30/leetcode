class LFUCache {

    class Node{
        int key;
        int value;
        int freq;

        Node(int key, int value){
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    private final int capacity;
    private final Map<Integer, Node>cache; // <parnika, <parnika : 1,1>>
    private final Map<Integer, LinkedHashSet<Node>> freqMap; //
    private int minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.freqMap = new HashMap<>();
        this.minFreq = 0;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)) return -1;
        Node node = cache.get(key);
        updateFreq(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(capacity<=0) return;

        if(cache.containsKey(key)){
            Node node = cache.get(key);
            node.value = value;
            updateFreq(node);
            return;
        }

        if(cache.size() == capacity){
            evict();
        }
        
        Node newNode = new Node(key,value);
        cache.put(key, newNode);
        freqMap.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(newNode);
        minFreq = 1;
    }

    //helpers 
    private void updateFreq(Node node){
        //get the old freq, 
        //freqMap se remove
        //cal new freq
        // update with new freq
        // put in freqMap 
        // if oldFreq group is empty && oldfreq == minFreq => minFreq will inc 

        int oldFreq = node.freq;
        freqMap.get(oldFreq).remove(node);

        int newFreq = oldFreq + 1;
        node.freq = newFreq;
        freqMap.computeIfAbsent(newFreq, k -> new LinkedHashSet<>()).add(node);

        if(freqMap.get(oldFreq).isEmpty() && oldFreq == minFreq){
            minFreq++;
        } 
    }

    private void evict(){
        LinkedHashSet<Node> minFreqSet = freqMap.get(minFreq);
        Node nodeToEvict = minFreqSet.iterator().next();
        minFreqSet.remove(nodeToEvict);
        cache.remove(nodeToEvict.key);
    }

}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */