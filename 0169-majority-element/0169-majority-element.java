class Solution {
    public int majorityElement(int[] nums) {
        HashMap <Integer, Integer>map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }

        for(int key : map.keySet()){
            int freq = map.get(key);
            if(freq > (nums.length/2)) return key;
        }

        return -1;
    }
}