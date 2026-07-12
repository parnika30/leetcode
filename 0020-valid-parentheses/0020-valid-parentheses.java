class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        for(char c : s.toCharArray()){
            //checking if the first char is an opening bracket
            if(c == '(' || c == '{' || c == '['){
                st.push(c); //(
            }else{
                //else possibilities are :
                //1. stack is empty => always invalid. 
                if(st.isEmpty()){
                    return false;
                }
                //2. st is not empty and check what's in st by popping
                else{
                    char popped = st.pop(); //(
                    if(
                        (c==')' && popped != '(') ||
                        (c==']' && popped != '[') || 
                        (c=='}' && popped != '{')
                    ){
                        return false;
                    }
                }
            }
        }
        return st.isEmpty(); // empty st always true
    }
}