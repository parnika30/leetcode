class MedianFinder {
        PriorityQueue<Integer> minheap;
        PriorityQueue<Integer> maxheap;

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
            return maxheap.peek();  // maxHeap has the extra element
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */