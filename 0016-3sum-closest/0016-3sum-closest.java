class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];
        for (int i =0; i< n-2; i++){
            int left = i + 1;
            int right = n-1;
            while(left<right){
                int sum = nums[i] + nums[left] + nums[right];
                if(Math.abs(sum-target) < Math.abs(closest - target)){
                    closest = sum; 
                } //Track the closest sum.
                if(sum>target) right--;
                else if(sum<target) left++;
                else return sum;
            }
        }
        return closest;
    }
}
// sort -> O(n log n)
// outer for -> O(n)
// 2 pointer -> O(N);
// total : O(n^2)