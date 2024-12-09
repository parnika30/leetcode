class Solution {
    public void nextPermutation(int[] nums) {
//         int index = -1 ;
//         int n = nums.length;
        
//         //1
//         for(int i = n-2; i>=0; i-- ){
//             if(nums[i]<nums[i+1]){
//                 index=i;
//                 break;
//             }
//         }
        
//         //edge
//          if (index == -1) {
//             reverse(nums, 0, n-1);
//             return;
//         }

//         //2
//         for(int i = n-1; i>index; i-- ){
//             if(nums[i]>nums[index]){
//                 int t = nums[i];
//                 nums[i] = nums[index];
//                 nums[index] = t;
//                 break;
//             }
//         }
        
//         //3
//         reverse(nums, index+1, n-1);
//     }
    
//     private void reverse(int[] nums, int start, int end){
//             while(start<end){
//                 int t = nums[start];
//                 nums[start] = nums[end];
//                 nums[start] = t;
//                 start++; end --; 
//             }
//         }
    
    
    
    
    
    int index = -1;
    int n = nums.length;

    // Step 1: Find the first decreasing element from the end
    for (int i = n - 2; i >= 0; i--) {
        if (nums[i] < nums[i + 1]) {
            index = i;
            break;
        }
    }

    // Step 2: If no such element is found, reverse the entire array
    if (index == -1) {
        reverse(nums, 0, n - 1); // Reverse the entire array to get the smallest permutation
        return; // Early exit
    }

    // Step 3: Find the next larger element to swap with nums[index]
    for (int i = n - 1; i > index; i--) {
        if (nums[i] > nums[index]) {
            int temp = nums[i];
            nums[i] = nums[index];
            nums[index] = temp;
            break;
        }
    }

    // Step 4: Reverse the elements after index to get the next permutation
    reverse(nums, index + 1, n - 1);
}

// Helper function to reverse a portion of the array
private void reverse(int[] nums, int start, int end) {
    while (start < end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        start++;
        end--;
    }
}
}