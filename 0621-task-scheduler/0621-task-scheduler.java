class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : tasks){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        //freq of each char in map

        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        maxheap.addAll(map.values());
        //add all the freq in pq

        Queue<int[]> q = new LinkedList<>();
        int time = 0;

        //heap se nikal ke q mei store karenge and firse heap mei add karenge
        while(!maxheap.isEmpty() || !q.isEmpty()){
            time++;
            if(!maxheap.isEmpty()){
                int count = maxheap.poll() -1;
                if(count > 0){
                    q.offer(new int[]{count, time+n});
                }
            }

            if(!q.isEmpty() && q.peek()[1] == time){
                maxheap.offer(q.poll()[0]);
            }
        }

        return time;
    }
}

//O(N). 
//tc of pq = log n => log 26 => O(1). 