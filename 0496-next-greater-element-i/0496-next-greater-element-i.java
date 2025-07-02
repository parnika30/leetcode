class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] res = new int[nums1.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        List<Integer> list = new ArrayList<>();

        for(int i=nums2.length-1; i>=0; i--){
            while(!st.isEmpty() && st.peek() <= nums2[i]){
                st.pop();
            }
            if(st.isEmpty()) map.put(nums2[i], -1);
            else map.put(nums2[i], st.peek());
            
            st.push(nums2[i]);
        }

        for(int num: nums1){
            list.add(map.get(num));
        }

        for(int i =0; i<nums1.length; i++){
            res[i] = list.get(i);
        }
        return res;
        
    }
}