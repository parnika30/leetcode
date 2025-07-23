class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[1]-b[1]);
        int n = intervals.length;
        int count = 0; 

        int last = intervals[0][1];
        for(int i=1; i<n;i++){
            int curr = intervals[i][0];
            if(curr<last){
                count++; //overlap
            }else{
                last = intervals[i][1]; //no overlap -> update last. 
            }
        }

        return count;
    }
}