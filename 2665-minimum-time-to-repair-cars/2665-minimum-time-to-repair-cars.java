class Solution {

    private boolean canRepairAll(int[] ranks, int cars, long time){
        long totalCarsRepaired = 0;
        for(int rank:ranks){
            totalCarsRepaired += Math.sqrt(time/rank);
            if(totalCarsRepaired >= cars) return true;  //the given time is sufficient or more than enough
        }
        return false;
    }
    public long repairCars(int[] ranks, int cars) {
        //A mechanic with the lowest rank (smallest r) is the fastest at repairing cars.
        //In the worst case, if only this fastest mechanic was available, they would do all the work.

        long right = (long)Arrays.stream(ranks).min().getAsInt()*cars*cars ; //(the smallest rank).
        long left = 1;
        while(left<right){
            long mid = left + (right-left)/2;
            if(canRepairAll(ranks, cars, mid)){ //mid is time here
                right = mid; //suff time hai to range kam karo
            } else{
                left = mid +1; //zayada time hai to range badhao 
            }
        }
        return left; //min time
    }
}