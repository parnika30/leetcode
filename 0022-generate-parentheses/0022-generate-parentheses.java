class Solution {
    private void backtrack(int open, int close, int n, StringBuilder s, List<String> res){
        //base case:
        if(open == n && open == close){ // all open brackets are used and created 1 valid combo
            res.add(s.toString());
            return;
        }

        if(open < n){
            s.append('(');
            backtrack(open+1, close, n, s, res);
            s.deleteCharAt(s.length()-1);
        }

        if(close < open){
            s.append(')');
            backtrack(open, close+1, n, s, res);
            s.deleteCharAt(s.length()-1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        backtrack(0,0,n,s,res);
        return res;
    }
}