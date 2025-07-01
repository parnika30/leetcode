class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> res = new ArrayList<>();
        int i = 0;
        
        //Keeps all intervals that end before newInterval starts—they don’t overlap, so no merge needed.
        while(i<intervals.length && intervals[i][1] < newInterval[0]){
            res.add(intervals[i++]);
        }

        //merge req
        while(i<intervals.length && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        res.add(newInterval);

        // Adds intervals that start after newInterval ends—again, 
        //no overlap, just append.
        while(i<intervals.length){
            res.add(intervals[i++]);
        }

        return res.toArray(new int[res.size()][]);
    }
}