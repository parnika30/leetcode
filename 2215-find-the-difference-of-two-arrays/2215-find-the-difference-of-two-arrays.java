class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        return Arrays.asList(result(nums2,nums1), result(nums1,nums2));
    }
      
    List<Integer> result(int[] nums1, int[] nums2){
                Set<Integer> s1 = new HashSet<> ();
        Set<Integer> s2 = new HashSet<> (); 
        
        for(int i: nums1){
            s1.add(i); //adding nums1 in s1   <1,2,3>
        }
        
        for(int j : nums2){
            if(!s1.contains(j)){
                s2.add(j);    // <4,6> => return this. 
            }
        }
        
        return new ArrayList<>(s2);
    }
}