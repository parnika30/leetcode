class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        int count = 0;
        HashMap<Integer, Integer> hs = new HashMap<>(); //sum,count
        hs.put(0,1);

        for(int num : nums){
            sum += num;
            count += hs.getOrDefault(sum-k,0);
            hs.put(sum, hs.getOrDefault(sum,0)+1);
        }
        return count;

    }
}