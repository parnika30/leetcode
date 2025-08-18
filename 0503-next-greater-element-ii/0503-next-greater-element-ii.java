class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        Stack<Integer> st = new Stack<>();
        List<Integer> list = new ArrayList<>();

        //2n-1; when i goes from 5 to 0 and n = 3, i % n cycles through 2, 1, 0, 2, 1, 0. This ensures every index is visited twice for the circular check.
        for(int i=2*n-1; i>=0; i--){ 
            while(!st.isEmpty() && st.peek() <= nums[i%n]){
                st.pop();
            }
            if(st.isEmpty()){
                res[i%n] = -1;
            }else{
                res[i%n] = st.peek();
            }
            st.push(nums[i%n]);
        }

        return res;
        
    }
}