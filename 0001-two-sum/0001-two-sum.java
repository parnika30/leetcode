class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hp = new HashMap<>();
        int n = nums.length;
        for(int i = 0; i<n; i++){
            if(hp.containsKey(target-nums[i])){
                return new int[]{hp.get(target-nums[i]),i};
            }else{
                hp.put(nums[i], i);
            }
            
        }
        return new int[]{};
    }
}