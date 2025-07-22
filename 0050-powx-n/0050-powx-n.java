class Solution {
    public double myPow(double x, int n) {
        long power = n; 

        if(power<0){
            n = -n;
            x = 1/x;
        }
        return powHelper(x, power);
    }

    private double powHelper(double x, long power){
        if(power == 0) return 1.0;

        if(power%2 == 0){
            return powHelper(x*x, power/2);
        }else{
            return x * powHelper(x*x, power/2);
        }

    }
}