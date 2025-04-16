class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        backtrack(nums,res,ds);
        return res;
    }
    private void backtrack(int[] nums, List<List<Integer>> res, List<Integer> ds){
        if(ds.size()==nums.length){
            res.add(new ArrayList<>(ds));
            return;
        }else{
            for(int i = 0; i < nums.length; i++){ 
                if(ds.contains(nums[i])) continue;
                ds.add(nums[i]);
                backtrack(nums,res,ds);
                ds.remove(ds.size()-1);
            }
        }
    }
}