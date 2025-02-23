class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        for(char c : s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                st.push(c);
            }else {
                if(st.isEmpty()){
                    return false;
                } else {
                    char popChar = st.pop();
                    if(
                        ( c == ')' && popChar != '(' )
                        || 
                        ( c == ']' && popChar != '[')
                        || 
                        ( c == '}' && popChar != '{')
                        ){
                        return false;
                    }
                }

            }
        }
        return st.isEmpty();
    }
}