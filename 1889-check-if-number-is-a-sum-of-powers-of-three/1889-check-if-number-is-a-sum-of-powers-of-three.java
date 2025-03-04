class Solution {
    public boolean checkPowersOfThree(int n) {
        String base3 = Integer.toString(n, 3);
        if(base3.contains("2")){
            return false;
        }else{
            return true;
        }
    }
}