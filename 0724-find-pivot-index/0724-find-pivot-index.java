class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;

        for(int i=0; i<nums.length; i++){
            sum = sum+nums[i];
        }
            int right = sum; 
            int left = 0; 
        
         for(int i=0; i<nums.length; i++){
             right = right - nums[i];
            if(right==left){
                return i;
            }
            left = left + nums[i];
        }
        return -1;
    }
}


// logic : 
//     1. whole sum, 
//     2. right = sum , left = 0 , 
//     3. for whole array : 
//         calculate:
//             right(-), comapre (r==l), left(+)