class Solution {
    public void nextPermutation(int[] nums) {
        int index = -1 ;
        int n = nums.length;
        
        //1
        for(int i = n-2; i>=0; i-- ){
            if(nums[i]<nums[i+1]){
                index=i;
                break;
            }
        }
        
        //edge
         if (index == -1) {
            reverse(nums, 0, n-1);
            return;
        }

        //2
        for(int i = n-1; i>index; i-- ){
            if(nums[i]>nums[index]){
                int t = nums[i];
                nums[i] = nums[index];
                nums[index] = t;
                break;
            }
        }
        
        //3
        reverse(nums, index+1, n-1);
    }
    
    private void reverse(int[] nums, int start, int end){
            while(start<end){
                int t = nums[start];
                nums[start] = nums[end];
                nums[end] = t;
                start++; 
                end --; 
            }
        }

}
