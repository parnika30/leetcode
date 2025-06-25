class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>((a,b)->b-a);

        for(int stone : stones){
            maxheap.offer(stone);
        }
        
        while(maxheap.size()>1){
            int i = maxheap.poll();
            int j= maxheap.poll();

            if(i!=j) maxheap.offer(i-j);
        }

        if(maxheap.isEmpty()){
            return 0;
        }else{
            return maxheap.poll();
        }
    }
}