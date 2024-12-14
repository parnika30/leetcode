class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
// use a hashmap,
// store key(array element), value(occurance) pair
// iterate through the hashmap
// if value> n/3 , then return the key. 
        
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int n = nums.length; 
        int max = (int)(n/3)+1;
        
        for(int i =0; i<n ;i ++){
            int value = map.getOrDefault(nums[i], 0);
            map.put(nums[i], value+1);
            
            if(map.get(nums[i]) == max){
            ans.add(nums[i]);
        }
            if(ans.size()==2){
                break;
            }
        }
        return ans;
        
    }
}