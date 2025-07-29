class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        backtrack(currList, n,k,res,1);
        return res;
    }

    void backtrack(List<Integer> currList, int n, int k, List<List<Integer>> res, int ind){

        if(currList.size() == k) {
            res.add(new ArrayList<>(currList)); 
            return;
        }

        for (int i = ind; i <= n; i++){
            currList.add(i);
            backtrack(currList,n,k,res,i+1);
            currList.remove(currList.size()-1);
        }
    }
    
}