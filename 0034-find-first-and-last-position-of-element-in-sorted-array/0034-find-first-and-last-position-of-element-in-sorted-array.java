class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        int last = findLast(nums, target);
        return new int[] {first, last};
    }

    private int findFirst(int[] nums, int target){
        int low = 0, high = nums.length-1;
        int res = -1;

        while(low<=high){
            int mid = (low+high)/2;
            if(target==nums[mid]){
                res = mid;
                high = mid-1;
            }

            else if(target>nums[mid]){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return res;
    }


    private int findLast(int[] nums, int target){
        int low = 0, high = nums.length-1;
        int res = -1;
        
        while(low<=high){
            int mid = (low+high)/2;
            if(target==nums[mid]){
                res = mid;
                low = mid+1;
            }

            else if(target>nums[mid]){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return res;
    }
}