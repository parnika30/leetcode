class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int n = heights.length ;
        int area = 0;

        for(int i =0; i<=n; i++){
            int currHeight = (i == n) ? 0 : heights[i];
            while(!st.isEmpty() && currHeight < heights[st.peek()]){
                int top = st.pop();
                int width = st.isEmpty() ? i : i - st.peek() - 1;
                int currArea = width * heights[top];
                area = Math.max(currArea, area);
            }
            st.push(i);
        }

        return area;
    }
}