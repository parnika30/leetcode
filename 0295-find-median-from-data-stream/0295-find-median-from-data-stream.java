class MedianFinder {
        PriorityQueue<Integer> minheap; //Larger half (min on top) 
        PriorityQueue<Integer> maxheap; //Smaller half (max on top)

    public MedianFinder() {
        minheap = new PriorityQueue<>();
        maxheap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        maxheap.offer(num);
        minheap.offer(maxheap.poll());  // Move the largest of maxHeap to minHeap

        if(minheap.size()>maxheap.size()){ // Balance sizes: maxHeap can have equal or 1 more than minHeap
            maxheap.offer(minheap.poll());
        }
    }
    
    public double findMedian() {
        if(minheap.size() == maxheap.size()){
            return (minheap.peek() + maxheap.peek())/2.0;
        }else{
            return maxheap.peek();  
            //If the total number of elements is odd, maxHeap has one extra element.
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */