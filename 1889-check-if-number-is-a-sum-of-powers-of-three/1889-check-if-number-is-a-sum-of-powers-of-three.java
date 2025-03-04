// class Solution {
//     public boolean checkPowersOfThree(int n) {
//         String base3 = Integer.toString(n, 3);
//         if(base3.contains("2")){
//             return false;
//         }else{
//             return true;
//         }
//     }
// }


class Solution {
    public boolean checkPowersOfThree(int n) {
        while(n>0){
            //construct the ternary representation of the given number by taking its remainder when divided by 3 (mod 3)
            if(n%3 == 2) return false; 
            n/=3;
            //dividing it by 3 to proceed to the next digit
            //if any of these remainders equals 2, 
            //we would need to use a power of 3 twice, which is not allowed. In that case, we immediately return false.
        }
        return true;
    }
}