//brute force -> O(N^3)
// class Solution {
//     public int specialTriplets(int[] nums) {
//         int count=0; 
//         for(int i=0; i<nums.length; i++){
//             for(int j=i+1; j<nums.length; j++){
//                 if(nums[i] != nums[j] * 2){
//                    continue;
//                 }

//                 for(int k=j+1; k<nums.length; k++){
//                     if(i<j && j<k && k<nums.length && 
//                         nums[i] == nums[j] * 2 && nums[k] == nums[j] * 2){
//                         count += 1;
//                     }
//                 }
//             }
//         }
//         return count % 1000000007;
//     }
// }


class Solution {
    static final int MODULO = 1_000_000_007;
    public int specialTriplets(int[] nums) {
        int count=0; 
        int n = nums.length;
        Map<Integer, Integer> leftCount = new HashMap<>();
        Map<Integer, Integer> rightCount = new HashMap<>();

        for(int i =0;i<n;i++){
            rightCount.put(nums[i], rightCount.getOrDefault(nums[i],0)+1);
        }

        for(int j =0;j<n;j++){
            int mid = nums[j];

            // update right count
            rightCount.put(mid, rightCount.get(mid)-1); //ek elemnet kam karo

            int left = leftCount.getOrDefault(mid*2, 0);
            int right = rightCount.getOrDefault(mid*2, 0);

            count = (int) ((count + (long) left * right) % MODULO);
            //count += ((long)left*right % MODULO);
            
             // update left count
            leftCount.put(mid, leftCount.getOrDefault(mid,0)+1);
        }
        return count;
    }
}