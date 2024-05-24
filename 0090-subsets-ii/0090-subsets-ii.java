class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer>store = new ArrayList<>();
        List<List<Integer>>result = new ArrayList<>();
        print(0,nums,store,result,false); 
        // !flag ensures that if we skipped the previous occurrence of this duplicate, we should skip       the current one as well.
        return result;
    }
    
    void print(int index, int[] nums, List<Integer>store, List<List<Integer>>result, Boolean flag){
        if(index == nums.length){
            result.add(new ArrayList<>(store));
            return;
        }
        print(index+1,nums,store,result,false);
        if (index>=1 && nums[index] == nums[index - 1] && !flag)return;
        store.add(nums[index]); //take the current element
        print(index+1,nums,store,result,true); //included
        store.remove(store.size()-1); //backtrack
    }
        
}