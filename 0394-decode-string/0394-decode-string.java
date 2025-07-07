class Solution {
    public String decodeString(String s) {
        Stack<StringBuilder> st = new Stack<>();
        Stack<Integer> count = new Stack<>();
        int n = s.length();
        StringBuilder res = new StringBuilder();
        int k =0;

        for(char ch : s.toCharArray()){
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');
            }else if(ch == '['){
                count.push(k);
                st.push(res);
                res = new StringBuilder();
                k = 0;
            }else if(ch == ']'){
                StringBuilder prev = st.pop();
                int times = count.pop();
                for(int i=0;i<times; i++)prev.append(res);
                res = prev;
            }else{
                res.append(ch);
            }

        }

        return res.toString();

    }
}