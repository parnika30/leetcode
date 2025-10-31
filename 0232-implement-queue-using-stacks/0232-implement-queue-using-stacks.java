class MyQueue {
    Stack<Integer>s1;
    Stack<Integer>s2;
    int front;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int x) {
        if(s1.isEmpty()){
            front = x;
        }
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        s2.push(x);
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        //tc -> O(n) : Each element is pushed and popped twice
        //The last inserted element is popped and pushed once
        
    }
    
    public int pop() {
        int popped = s1.pop();
        if(!s1.isEmpty()){
            front = s1.peek();
        }
        return popped;

        //O(1)
    }
    
    public int peek() {
        return front; //O(1)
    }
    
    public boolean empty() {
        return s1.isEmpty(); //O(1)
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */