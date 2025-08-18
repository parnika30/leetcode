class Solution {
    public int maxSum(int[] nums1, int[] nums2) {
        int MOD = 1_000_000_007;
        long sum1 = 0;;
        long sum2 = 0;

        int n = nums1.length, m = nums2.length;
        int i=0, j=0;
        long res =0;

        while(i<n && j<m){
            if(nums1[i] < nums2[j]){
                sum1 += nums1[i++];
            }else if(nums1[i] > nums2[j]){
                sum2 += nums2[j++];
            }else{
                res += Math.max(sum1, sum2) + nums1[i];
                sum1 = 0;
                sum2 = 0;
                i++;
                j++;
            }
        }

        while(i<n) sum1 += nums1[i++]; 
        while(j<m) sum2 += nums2[j++];

        res += Math.max(sum1, sum2);
        return (int)(res % MOD);
    }
}