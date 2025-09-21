class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int prefix = 1;
        int suffix = 1;
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(prefix == 0)prefix = 1;
            if(suffix == 0)suffix = 1;
            prefix *= nums[i]; //p = 2, 6
            suffix *= nums[n-i-1]; //s= 4, -8
            ans = Math.max(ans, Math.max(prefix,suffix)); //ans = 4, 6,  
        }
        return ans;
    }
}