class Solution {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        int n = nums.length;
        int prod = 1;
        for(int i = 0; i < n-1; i++){
            prod = (nums[i]-1) * (nums[i+1]-1);
            max = Math.max(max,prod);

        }
        return max;
    }
}