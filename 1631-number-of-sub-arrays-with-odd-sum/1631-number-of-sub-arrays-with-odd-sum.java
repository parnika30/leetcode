class Solution {
    public int numOfSubarrays(int[] arr) {
        int mod = 1000000007;
        int oddcount =0;
        int evencount = 1;
        int sum =0;
        int result =0;

        for(int i : arr){
            sum += i;

            if(sum % 2 ==0 ){
                result = (result + oddcount)%mod;
                evencount ++;
            }else{
                result = (result + evencount)%mod;
                oddcount ++; 
            }
        }
        return result;
    }
}