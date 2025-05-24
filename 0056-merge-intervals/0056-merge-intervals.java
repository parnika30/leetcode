class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        res.add(intervals[0]);
        for(int i = 1; i<intervals.length; i++){
            int[] last = res.get(res.size()-1);
            if(intervals[i][0] <= last[1]){ //2<3
                last[1] = Math.max(last[1], intervals[i][1]); //max(3,6)
            }else{
                res.add(intervals[i]);
            }
        }
        return res.toArray(new int[res.size()][]);
        
    }
}