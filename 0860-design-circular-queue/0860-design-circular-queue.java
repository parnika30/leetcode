class Node{
    public int value;
    public Node next;

    public Node(int value){
        this.value = value;
        this.next = null;
    }
}
    
class MyCircularQueue {
    private Node head, tail;
    private int capacity;
    private int length; 

    public MyCircularQueue(int k) {
        this.capacity = k;
    }
    
    public boolean enQueue(int value) {
        if(length == capacity)return false;

        Node newNode = new Node(value);
        if(length == 0){
            head = tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        length += 1;
        return true;
    }
    
    public boolean deQueue() {
        if(length == 0)return false;

        head = head.next;
        length -= 1;
        return true;
    }
    
    public int Front() {
        if(length == 0) return -1;
        return head.value;
    }
    
    public int Rear() {
        if(length == 0) return -1;
        return tail.value;
    }
    
    public boolean isEmpty() {
        return (length==0);
    }
    
    public boolean isFull() {
        return (length == capacity);
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */