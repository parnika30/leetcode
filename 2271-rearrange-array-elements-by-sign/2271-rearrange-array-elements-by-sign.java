class Solution {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        for(int num : nums){
            if(num<0) neg.add(num);
            else pos.add(num);
        }

        int[] res = new int[nums.length];
        int p= 0, n=0, i=0;
        while(i<nums.length){
           res[i++] = pos.get(p++);
          // i++; p++;
           res[i++] = neg.get(n++);
           //i++; n++;
        }

        return res;
    }
}