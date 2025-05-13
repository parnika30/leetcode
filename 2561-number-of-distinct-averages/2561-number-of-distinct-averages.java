// class Solution {
//     public int distinctAverages(int[] nums) {
//         Set<Double> set = new HashSet<>();
//         int l = 0;
//         int h = nums.length-1;
//         int big = Integer.MIN_VALUE;
//         int small = Integer.MAX_VALUE;

//         while(l<h){
//             // if(nums[l] < nums[h]){
//             //     small = Math.min(nums[l], small);
//             //     big = Math.max(nums[h], big);
//             //     l++; h--;
//             // }
//             // if(nums[l] > nums[h]){
//             //     small = Math.min(nums[h], small);
//             //     big = Math.max(nums[l], big);
//             //     l++; h--;
//             // }

//             double avg = (nums[l]+nums[h])/2;
//             set.add(avg);
//             l++; h--;

//         }
//         return set.size();
//     }
// }


class Solution { //nLogn
    public int distinctAverages(int[] nums) {
        Set<Double> set = new HashSet<>();
        int l = 0;
        int h = nums.length-1;
        Arrays.sort(nums);
        while(l<h){
            double avg = (nums[l]+nums[h])/2.0;
            set.add(avg);
            l++; h--;

        }
        return set.size();
    }
}