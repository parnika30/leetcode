//brute force
// class Solution {
//     public int findMin(int[] nums) {
//         int min = Integer.MAX_VALUE;
//         for(int i = 0; i<nums.length; i++){
//             min = Math.min(min,nums[i]);
//         }
//         return min;
//     }
// }

//binary search

class Solution {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        int low = 0, high = nums.length-1;

        while(low<=high){
            int mid = (low+high)/2;
            if(nums[low]<=nums[mid]){
                min = Math.min(min,nums[low]);
                low = mid+1;
            }else{
                min = Math.min(min,nums[mid]);
                high = mid-1;
            }
        }
        return min;
    }
}