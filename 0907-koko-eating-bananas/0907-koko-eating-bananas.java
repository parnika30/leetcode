
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1; 
        // int high = 0;
        // for (int p : piles) {
        //     high = Math.max(high, p);
        // }

        int high = Arrays.stream(piles).max().getAsInt();
        while(low<=high){
            int mid = (low+high)/2;
            int time = 0;

            for(int p : piles){
                // int timeToFinish = Math.ceil((double)p/mid);
                // time += timeToFinish;  // Time to finish each pile
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

