class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum =0;
        long max = 0;
        int i=0;
        HashSet<Integer> hs = new HashSet<>();
        for(int j=0; j<nums.length; j++){

            // If duplicate, shrink window from left
            while(hs.contains(nums[j])){
                hs.remove(nums[i]);
                sum -= nums[i];
                i++;
            }
            hs.add(nums[j]);
            sum += nums[j];

            // If window size exceeds k, shrink
            if(j-i+1>k){
                hs.remove(nums[i]);
                sum -= nums[i];
                i++;
            }
            // If window size is exactly k and all distinct
            if(j-i+1==k){
                max = Math.max(max,sum);

            }
        }
        return max;
    }
}