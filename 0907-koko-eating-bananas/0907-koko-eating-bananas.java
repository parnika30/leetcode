// we know the range, we need to find the least value at which speed is possible => binary search. 
//[1,2,3,4(least speed),5,6,7,8,9,10,11]
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1; 
        int high = 0;
        for (int p : piles) {
            high = Math.max(high, p);  //to find max bananas/hr  (min = 1; max = max in the array)
        }
        while(low<=high){
            int mid = (low+high)/2;
            int time = 0;

            //for findin time
            for(int p : piles){ 
                time += Math.ceil((double) p / mid);
            }

            if(time>h){
                low = mid+1; //high speed
            }else{
                high = mid-1; // Try a slower speed
            }
        }

        return low;
    }
}


// //brute force
// class Solution {
//     public int minEatingSpeed(int[] piles, int h) { 
//         int max = 0;
//         for (int p : piles) {
//             max = Math.max(max, p);  //to find max bananas/hr  (min = 1; max = max in the array)
//         }

// // we know the range, we need to find the least value at which speed is possible => binary search. 
// //[1,2,3,4(least speed),5,6,7,8,9,10,11]

//         for(int i = 1; i<max; i++){  //(1->max)
//             int time = 0;
//             for (int p : piles) { //for each pile
//                 time += Math.ceil((double) p / i);
//             }
//             if (time <= h) {
//                 return i; // minimum speed that works
//             }
//         }
        
//         return max;
//     }
// }