class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]> minheap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for(int i=0;i<nums.length; i++){
            if(minheap.size() < k) minheap.offer(new int[]{nums[i], i});
            else if(nums[i] > minheap.peek()[0]){
                minheap.poll();
                minheap.offer(new int[]{nums[i], i});
            }
        }
        ArrayList<int[]> list = new ArrayList<>(minheap);
        Collections.sort(list, (a,b) -> a[1]-b[1]);
        int[] res = new int[k];

        for(int i=0;i<k;i++){
           res[i] = list.get(i)[0];
        }

        return res;
    }
}