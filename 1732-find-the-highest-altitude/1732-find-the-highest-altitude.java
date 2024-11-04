class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int num = 0;
        for(int val:gain){
            num+=val;
            max=Math.max(num,max);
        }
        return max;
    }
}