class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }

    private void reverse (int[] nums, int start, int end){
        while(start < end){
            int t = nums[start];
            nums[start] = nums[end];
            nums[end] = t;
            start++;
            end--;
        }
    }
}

// Input: nums = [1,2,3,4,5,6,7], k = 3 3%7 = 3
// Output: [5,6,7,1,2,3,4]

// 1st : [1,2,3,4,5,6,7
// s=0, e=6:  7,2,3,4,5,6,1 
// s=1, e=5:  7,6,3,4,5,2,1
// s=2, e=4:  7,6,5,4,3,2,1


// 2nd : [7,6,5,4,3,2,1]
// s=0, e=2:  5,6,7,4,3,2,1

// 3rd : [5,6,7,4,3,2,1]
// s=3, e=6:  5,6,7,1,3,2,4
// s=4, e=5:  5,6,7,1,2,3,4
