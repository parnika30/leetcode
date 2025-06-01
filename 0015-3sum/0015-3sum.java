// better approach 

// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
//         Set<List<Integer>> resultSet = new HashSet<>();
//         for(int i=0; i<nums.length; i++){
//             //declare the set for storing elemets here because everytime i changes, set should be empty.
//             Set<Integer> hashset = new HashSet<>();
//             for(int j=i+1; j<nums.length;j++){
//                 int third = -(nums[i]+nums[j]);

//                 // num[i],nums[j], third -> new list mei daaldo, 
//                 // list ko sort karo.
//                 // sort karkle, list ko resultSet mei daaldo
//                 if(hashset.contains(third)){
//                     List<Integer> newList = Arrays.asList(nums[i], nums[j], third);
//                     Collections.sort(newList);
//                     resultSet.add(newList);
//                 }
//                 hashset.add(nums[j]);
//             }
//         }
//         List<List<Integer>> finalResultList = new ArrayList<>(resultSet);
//         return finalResultList;
//     }

//     //tc - n^2*log(size of hashset)
// }



class Solution{
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for(int i =0;i<nums.length;i++){
            // check for duplicates, if found , pointer will move forward (continue)
            if(i !=0 && nums[i]== nums[i-1]){
                continue;
            }
            //move the two pointeres j & k
            int j = i+1;
            int k = nums.length-1;

            //j & k should not cross 
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum>0){
                    k--;
                }else if(sum < 0){
                    j++;
                }else{ // point where we found the triplets, 
                    // triplets ko list mei daalo, pointers ko aage badhao
                    List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);
                    result.add(list);
                    j++; 
                    k--;

                    //for skipping the duplicate triplets
                    while(j<k && nums[j]==nums[j-1]) j++;
                    while(j<k && nums[k]==nums[k+1]) k--;
                }
            }
        }
        return result;
    }


    //tc - NLogN -> sorting +O(N(for)*N). = nlogn + O(N^2)
}