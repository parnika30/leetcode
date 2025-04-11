class Solution {
    public int search(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        int low = 0, high = nums.length-1;

        while(low<=high){
            int mid = (low+high)/2;
            if(target==nums[mid]){
                return mid;
            }
            
            // Left half is sorted
            if(nums[low]<=nums[mid]){
                if(target>=nums[low] && target<nums[mid]){ // got target in left sorted array
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }
            // right half is sorted
            else{
                if(target>nums[mid] && target<=nums[high]){ // got target in right sorted array
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}