class Solution {
    public String removeDuplicates(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        st.push(s.charAt(0));

        for(int i=1;i<n;i++){
            char curr = s.charAt(i);
            if(!st.isEmpty() && st.peek() == curr){
                st.pop();
            }else{
                st.push(curr);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.reverse().toString();

    }
}