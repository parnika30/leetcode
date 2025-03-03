// class Solution {
//     public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
//     HashMap<Integer, Integer> hs = new HashMap<>();

//     // Merge nums1 into the map
//     for (int[] num : nums1) {
//         hs.put(num[0], hs.getOrDefault(num[0], 0) + num[1]);  
//         //num[0] : id, num[1] : value
//         //Merges duplicate IDs by summing values
//     }

//     // Merge nums2 into the map
//     for (int[] num : nums2) {
//         hs.put(num[0], hs.getOrDefault(num[0], 0) + num[1]);
//     }

//     // Convert the map into a 2D result array
//     int[][] res = new int[hs.size()][2];
//     int i = 0;
//     for (var entry : hs.entrySet()) {
//         res[i][0] = entry.getKey();
//         res[i][1] = entry.getValue();
//         i++;
//     }

//     return res;
// }
//}



class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        HashMap<Integer, Integer> hs = new HashMap<>();
        for(int[] i : nums1){
            hs.put(i[0], i[1]);
        }
        for(int[] j : nums2){
            if(hs.containsKey(j[0])){
                hs.put(j[0], hs.get(j[0]) + j[1]); 
            }else{
                hs.put(j[0], j[1]);
            }
        }

        int[] arr = new int[hs.size()]; //store only the keys.
        int x = 0;
        for(int i : hs.keySet()){
            arr[x] = i;
            x++;
        }

        Arrays.sort(arr);
        int[][] result = new int[hs.size()][2];
        for(int i = 0; i < arr.length; i++){
            result[i] = new int[]{arr[i], hs.get(arr[i])};
        }
        return result;
    }
}