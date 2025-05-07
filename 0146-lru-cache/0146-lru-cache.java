// Structure of Doubly Linked List
class Node
{
    int key;
    int value;
    Node next;
    Node prev;
    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }


    Node() {}
}

class LRUCache {
    HashMap<Integer,Node> hp = new HashMap<>();
    Node head = new Node();
    Node tail = new Node();
    int cap = 0; //capacity


    //helper for delete and insert
    private void deleteNode(Node node) {
        if (node == null || node == head || node == tail) return;

        Node prevNode = node.prev;
        Node afterNode = node.next;

        if (prevNode != null) prevNode.next = afterNode;
        if (afterNode != null) afterNode.prev = prevNode;
    }


    private void insertNodeAfterHead(Node node){
        Node curr =  head.next;
        head.next = node;
        node.next = curr;
        node.prev = head;
        curr.prev = node;
    }

    public LRUCache(int capacity) { //O(1)
        cap = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) { //O(1)
        if(!hp.containsKey(key)) return -1;
        Node newNode = hp.get(key);
        deleteNode(newNode); //delete from last => to maintain LRU. 
        insertNodeAfterHead(newNode); //insert at first 
        return newNode.value;
    }
    
    public void put(int key, int value) {
        if(hp.containsKey(key)){
            Node newNode = hp.get(key);
            newNode.value = value;
            deleteNode(newNode); //since recently used : delete from last
            insertNodeAfterHead(newNode); //insert at first 
            return;
        }
        if(hp.size()==cap){
            //get rid of least recently used
            Node nodeToDel = tail.prev;
            deleteNode(nodeToDel);
            hp.remove(nodeToDel.key);
        }
        //fully new
        Node node = new Node(key,value);
        hp.put(key, node);
        insertNodeAfterHead(node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */