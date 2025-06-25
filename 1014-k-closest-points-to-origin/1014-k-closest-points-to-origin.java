class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> b[0]-a[0]);
        int n = points.length;
        int m = points[0].length;
        
        for(int[] point : points){
            int x = point[0];
            int y = point[1];
            int distance = (x*x)+(y*y);

            //how to add distance and the points to the minheap ? 
            minHeap.offer(new int[]{distance, x, y});
            if(minHeap.size() > k) minHeap.poll();
        }

        int[][] res = new int[k][2];
        for(int i=0;i<k;i++){
            int[] polled = minHeap.poll();
            res[i][0] = polled[1];
            res[i][1] = polled[2];
        }

        return res;

    }
}