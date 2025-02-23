class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        int longest = 1;
        int count = 0;

        if(n == 0)
        return 0; 

        HashSet<Integer> hs = new HashSet<Integer>(); 
        for(int i = 0 ; i < n ; i ++){
            hs.add(nums[i]);
        }
        for(int t : hs){
            if(!hs.contains(t-1)){
                count = 1;
                int x = t;
                while(hs.contains (x+1)){
                    x = x + 1;
                    count ++;
                }
            }
            longest = Math.max(longest, count);
        }
        return longest;
        
    }
}