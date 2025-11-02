class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer>hs1 = new HashSet<>();
        HashSet<Integer>hs2 = new HashSet<>();

        for(int num : nums1){
            hs1.add(num); //1,2
        }

        for(int num : nums2){
            if(hs1.contains(num)){ 
                hs2.add(num); 
            }
        }
        return hs2.stream().mapToInt(Integer::intValue).toArray();
    }
}