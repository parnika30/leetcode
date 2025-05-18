class Solution {
    public int findPairs(int[] nums, int k) {
        HashMap<Integer, Integer> hp = new HashMap<>();
        int ans = 0;
        for(int num: nums){
            hp.put(num, hp.getOrDefault(num,0)+1);
        }

        for(int i : hp.keySet()){
            if(k > 0  && hp.containsKey(i+k) ||
                k == 0 && hp.get(i) > 1){  //>1 because diff of same ele == k == 0  
                    ans ++;
                }
        }
        return ans; 

    }
}