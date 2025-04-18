//auxilary space of dp array O(n) is used.
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        //Math.max(exculded last, excluded first)
        return Math.max(robLinear(nums, 0, n - 2), robLinear(nums, 1, n - 1));
    }

    private int robLinear(int[] nums, int first, int last){
        int len = last - first + 1;
        if(len ==1) return nums[first];

        int[] dp = new int[len];
        dp[0] = nums[first];
        dp[1] = Math.max(nums[first], nums[first+1]);

        for (int i =2 ;i<len;i++){
            int take = nums[first + i] + dp[i-2];
            int leave = 0+dp[i-1];
            dp[i] = Math.max(take,leave);
        }
        return dp[len-1];
    }
}
