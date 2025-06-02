class Solution {
    public int maxProduct(int[] nums) {
        int first = 0;
        int sec = 0; 
        for(int i : nums){
            if(i > first){
                sec = first;
                first = i; 
            }else if(i > sec){
                sec = i;
            }

        }
        return (first-1) * (sec-1);
    }
}