class Solution {
    // public boolean containsDuplicate(int[] nums) {
    //     Arrays.sort(nums);
    //     for(int i=0;i<nums.length-1;i++){
    //             if(nums[i]==nums[i+1])
    //             return true;
    //         }
    //     return false;
    //     }


    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }
        if(set.size() == nums.length) return false;
        else return true;
    }
}