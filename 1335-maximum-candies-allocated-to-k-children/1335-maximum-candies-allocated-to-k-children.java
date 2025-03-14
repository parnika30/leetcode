class Solution {
    public int maximumCandies(int[] candies, long k) {
        int res = 0, l = 1, r = 10000000;
        while(l<=r){
            int mid = l + (r-l)/2;
            long children = 0;

            for(int i:candies){
                children += i/mid ;
            }

            //If childrenCount >= k, update result = mid because it's a valid answer
            //Continue searching for a larger valid mid in the right half.
            if(children >= k){
                res = mid;
                l = mid+1;
            }else{
                r = mid -1;
            }
        }
        return res;
    }
}