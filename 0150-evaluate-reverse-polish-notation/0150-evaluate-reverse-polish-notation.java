class Solution {

    private long calc(long a, long b, char op){
        if(op == '+') return a+b;
        else if(op == '-') return a-b;
        else if(op == '*') return a*b;
        else return a/b;
    }

    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        Stack<Long> st = new Stack<>();
        for(int i =0; i<n; i++){
            char o = tokens[i].charAt(0);
            if(tokens[i].length() == 1 && (
                o ==  '+' || o ==  '-' || 
                o ==  '*' || o ==  '/')
            ){
                long n2 = st.pop();
                long n1 = st.pop();
                char operator = tokens[i].charAt(0);

                long ans = calc(n1, n2, operator);
                st.push(ans);
            }else{
                st.push(Long.parseLong(tokens[i]));
            }
        }

        return st.pop().intValue();
    }
}