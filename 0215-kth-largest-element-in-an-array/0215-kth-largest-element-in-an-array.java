class Solution {
    public int findKthLargest(int[] nums, int k) {
        int max = 0;
        PriorityQueue<Integer> maxheap = new PriorityQueue<>((a,b) -> b - a);
        for(int i : nums){
            maxheap.offer(i);
        }
        for(int i =0; i<k;i++){
            max = maxheap.poll();
        }
        return max;
    }
}