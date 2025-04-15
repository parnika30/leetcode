//TLE => 2^n * k * log(set size) 
// class Solution {
    
//     private void findCombo(int ind, int target, List<Integer> ds, int[]arr , HashSet<List<Integer>> ans){
//          //base condition 
//         if(ind == arr.length){
//             if(target==0){
//                 ans.add(new ArrayList<>(ds));
//             }
//             return; 
//         }
        
//         if(arr[ind]<=target){
//             //take condition
//             ds.add(arr[ind]);
//             findCombo(ind+1,target-arr[ind],ds,arr,ans); //increaed the index
//             ds.remove(ds.size()-1);
//         }
//         //not take condition
//         findCombo(ind+1,target,ds,arr,ans);
//     }
    
//     public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//         Arrays.sort(candidates);
//         HashSet<List<Integer>> ans = new HashSet<>();
//         List<Integer> ds = new ArrayList<>();
//         findCombo(0,target,ds,candidates,ans);
//         return new ArrayList<>(ans);
//         //return ans; 
//     }
// }


//tc = 2^n * k 
class Solution {
    
    private void backtrack(int ind, int target, List<Integer> ds, int[]arr , ArrayList<List<Integer>> ans){
         //base condition 
        if(target==0){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i = ind; i< arr.length; i++){
            // If the current number is equal to the previous one, and
            // We're still at the same recursion level (i > ind),
            // Then we skip it to prevent duplicate combinations.
            if(i>ind && arr[i] == arr[i-1]) continue;
            if(arr[i] > target) break;
            ds.add(arr[i]); //(k -> k is the avg length of each combination)
            backtrack(i+1, target-arr[i], ds, arr, ans);
            ds.remove(ds.size()-1);
        }
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        ArrayList<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        backtrack(0,target,ds,candidates,ans);
        return ans; 
    }
}