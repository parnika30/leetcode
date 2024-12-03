// brute force 
// class Solution {
//     public int maxSubArray(int[] nums) {
//          int n = nums.length;
//         int max = Integer.MIN_VALUE;
//         for(int i =0; i<n; i++){
//             int sum = 0;
//             for(int j =i; j<n; j++){
//                 sum += nums[j];
//                 max = Math.max(max,sum);
//             }
//         }
//         return max;
//     }
// }



//optimized -
class Solution {
    public int maxSubArray(int[] nums) {
         int n = nums.length;
        int max = Integer.MIN_VALUE;
        int max_sum =0; 
        for(int i =0; i<n; i++){
            max_sum+=nums[i];
            if(max_sum>max){
                max = Math.max(max_sum,max);
            }
            
            if(max_sum<0){
                max_sum=0;
            }
        }
        return max;
    }
}