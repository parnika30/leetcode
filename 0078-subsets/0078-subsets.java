class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer>store = new ArrayList<>();
        List<List<Integer>>result = new ArrayList<>();
        print(0,nums,store, result);
        return result;
    }
    
    void print(int index, int[] nums, List<Integer>store, List<List<Integer>>result){
        if(index == nums.length){
            result.add(new ArrayList<>(store));
            return;
        }
        store.add(nums[index]); //take 
        print(index+1,nums,store,result);
        store.remove(store.size()-1); //backtrack
        print(index+1,nums,store,result); //not take
    }
        
}