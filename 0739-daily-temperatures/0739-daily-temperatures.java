class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int res[] = new int[n];

        Stack<int[]> st = new Stack<>(); //each ele is [temp, ind]
        for(int i =0;i<n;i++){
            int curr = temperatures[i];
            while(!st.isEmpty() && curr > st.peek()[0]){
                int[] top = st.pop();
                int prevInd = top[1];
                res[prevInd] = i - prevInd;
            }

            st.push(new int[]{curr, i});
        }

        return res;
    }

}