class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n*(n+1)/2; //sum of n natural numbers
        int sumOfArray = 0;
        for(int i : nums){
            sumOfArray += i; 
        }
        int missing = sum - sumOfArray;
        return missing;
    }
}