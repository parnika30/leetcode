class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int lmax = 0;
        int rmax = height[r];
        int total = 0;

        while(l<r){
            if(height[l]<=height[r]){
                if(height[l] < lmax){
                    total += (lmax - height[l]);
                }else{
                    lmax = height[l];
                }
                l++;
            }else {
                if(height[r] < rmax){
                    total += (rmax - height[r]);
                }else{
                    rmax = height[r];
                }
                r--;
            }
        }
        return total;
    }
}