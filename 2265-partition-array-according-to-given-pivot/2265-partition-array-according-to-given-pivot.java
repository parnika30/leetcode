class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int res [] = new int[n];
        int start = 0; 
        int end = n-1; 

        for(int i = 0 ; i< n; i++){
            if(nums[i]<pivot){
                res[start] = nums[i];
                start++;
            }
        }

        for(int i = n-1 ; i>=0; i--){
            if(nums[i]>pivot){
                res[end] = nums[i];
                end--;
            }
        }

        while(start <= end){
            res[start] = pivot;
            start++;
        }

        return res;
    }
}