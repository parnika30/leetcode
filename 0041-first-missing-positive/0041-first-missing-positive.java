class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length; 
        
        // for(int i=0;i<n;i++){
        //     if(nums[i] != 1){
        //         if(nums[i] <= 0) continue;
        //         else{
        //             while(nums[i] >0 && nums[i] <= n && nums[nums[i] -1] != nums[i]){
        //                 int t = nums[nums[i] -1];
        //                 nums[nums[i] -1] = nums[i];
        //                 nums[i] = t;
        //             }
        //         }
        //     }
        //     if(nums[i] != i+1) return i+1;
        // }
        // return n+1;

        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        for(int i=1;i<=n+1;i++){
            if(!set.contains(i)){
                return i;
            }
        }
        return -1;
    }
}