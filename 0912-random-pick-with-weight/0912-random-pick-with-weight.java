class Solution {
    private int[] prefixSum;
    private int total;

    public Solution(int[] w) {
        this.prefixSum = new int[w.length];

        int pfSum = 0;
        for(int i=0;i<w.length;i++){
            pfSum += w[i];
            this.prefixSum[i] = pfSum;  
        }
        this.total = pfSum;
    }
    
    public int pickIndex() {
        double target = this.total * Math.random();
        int l =0, h = this.prefixSum.length; 
        while(l<h){
            int mid = l + (h-l)/2;
            if(target > this.prefixSum[mid]){
                l = mid+1;
            }else{
                h = mid;
            }
        }
        return l;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */