class Solution {
    int ele;
    // public int majorityElement(int[] nums) {
    //     HashMap <Integer, Integer>map = new HashMap<>();
    //     for(int n : nums){
    //         map.put(n, map.getOrDefault(n,0)+1);
    //     }

    //     for(int key : map.keySet()){
    //         int freq = map.get(key);
    //         if(freq > (nums.length/2)) return key;
    //     }

    //     return -1;
    // }


    public int majorityElement(int[] nums) {
        int count=0, n = nums.length;

        for(int i=0;i<n;i++){
            if(count == 0){
                count++;
                ele = nums[i];
            }else if(nums[i] == ele){
                count++;
            }else{
                count--;
            }
        }

        int c = 0;
        for(int i=0;i<n;i++){
            if(nums[i] == ele){
                c++;
            }
        }

        if(c > n/2) return ele;
        return -1;
    }
}