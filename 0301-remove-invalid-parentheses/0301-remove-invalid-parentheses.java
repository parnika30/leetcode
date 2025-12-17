class Solution {
    private HashSet<String> validExp = new HashSet<String>();
    private int minRemoved;

    private void reset(){
        validExp.clear();
        minRemoved = Integer.MAX_VALUE;
    }

    private void recurse(String s, int ind, int leftC, int rightC, StringBuilder exp, int removedCount){
        if(ind == s.length()){
            if(leftC == rightC){
                if(removedCount <= minRemoved){
                    String ans = exp.toString();
                    if(removedCount < minRemoved){
                        validExp.clear();
                        minRemoved = removedCount;
                    }
                    validExp.add(ans);
                }
            }
        }else{
            char currChar = s.charAt(ind);
            int length = exp.length();

            if(currChar!= '(' && currChar != ')'){
                exp.append(currChar);
                recurse(s,ind+1,leftC,rightC, exp, removedCount);
                exp.deleteCharAt(length);
            }else{
                recurse(s,ind+1,leftC,rightC, exp, removedCount+1);
                exp.append(currChar);
                if(currChar == '('){
                    recurse(s,ind+1,leftC+1,rightC,exp, removedCount);
                }else if(rightC < leftC){
                    recurse(s,ind+1,leftC,rightC+1,exp,removedCount);
                }
                exp.deleteCharAt(length);
            }
        }
    }

    public List<String> removeInvalidParentheses(String s) {
        reset();
        recurse(s,0,0,0,new StringBuilder(),0);
        return new ArrayList<>(validExp);
    }
}