class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int sum = 0;
        int minsum = 0;
        int maxsum = 0;

        for(int i : nums){
            sum += i;
            if(sum > maxsum){
                maxsum = sum;
            }
            if(sum < minsum){
                minsum = sum;
            }
        }
        return Math.abs(maxsum - minsum);
    }
}