class Solution {
    public int shipWithinDays(int[] weights, int days) {
        //lower and upper bound
        // run binary search on them
        int max = Integer.MIN_VALUE;
        int up = 0;
        int result = 0;
        for(int weight : weights){
            max = Math.max(weight,max); 
            up += weight;
        }
        int low = max; 
        result = up;

        while(low<=up){
            int mid =  low + (up - low) / 2;
            if(canShip(mid, days, weights)){ //mid is the capacity
                result = Math.min(result,mid); //new min
                up = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return result;
    }

    private boolean canShip(int capacity, int days, int[] weights){
        int daysNeeded = 1; //min 1 din to lagega hi
        int currCap = capacity;

        for(int w : weights){
            if(currCap - w  < 0){ //if currCap cannot hold the weight
                daysNeeded++; // more days needed
                currCap = capacity; //fresh day, fresh capacity
            }
            currCap -= w; 
        }
        return daysNeeded <= days;
    }
}