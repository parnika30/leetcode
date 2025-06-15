class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
    //     for(int i=0; i<nums.length; i++){
    //         for(int j=0; j<nums.length; j++){
    //             if(Math.abs(i-j) == k && nums[i] == nums[j]){
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }

    //brute force O(N^2)

        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
            if(set.size()>k){
                set.remove(nums[i-k]);
            }
        }
        return false;
    }
}