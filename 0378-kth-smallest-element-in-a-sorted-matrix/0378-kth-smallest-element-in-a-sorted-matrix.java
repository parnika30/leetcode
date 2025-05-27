class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int count = 0;
        int n = matrix.length; // Number of rows
        int m = matrix[0].length; 
        int h = (n*m) - 1;
        int l = 0;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        for(int i = 0; i<n; i++){
            minHeap.add(new int[]{matrix[i][0], i, 0}); //(value, row, col)).
        }

        int res = 0;
        for(int i = 0; i<k; i++){
           int[] curr = minHeap.poll();
           res = curr[0]; //extract the value
           if(curr[2] < n-1){ //If curr[2] is already at the last column
            minHeap.add(new int[]{matrix[curr[1]][curr[2]+1], curr[1], curr[2]+1}); 
            //it means we haven’t reached the end of the row. So, we push the next element from that row into the minHeap.
           }
        }
        return res;
    }
}