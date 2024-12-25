class Solution {
    
    private void findCombo(int ind, int target, List<Integer>ds, int[]arr , List<List<Integer>> ans){
         //base condition 
        if(ind == arr.length){
            if(target==0){
                ans.add(new ArrayList<>(ds));
            }
            return; 
        }
        
        if(arr[ind]<=target){
            //take condition
            ds.add(arr[ind]);
            findCombo(ind,target-arr[ind],ds,arr,ans);
            ds.remove(ds.size()-1);
        }
        //not take codition
        findCombo(ind+1,target,ds,arr,ans);
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        findCombo(0,target,ds,candidates,ans);
        return ans; 
    }
}