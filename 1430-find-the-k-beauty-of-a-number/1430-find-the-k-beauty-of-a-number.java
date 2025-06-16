class Solution {
    public int divisorSubstrings(int num, int k) {
        int count = 0;
        String str = String.valueOf(num);
        for(int i =0; i<str.length()-k+1; i++){
            String temp = str.substring(i, i+k);
            int n = Integer.valueOf(temp);
            if(n==0) continue;
            if(num%n==0) count++;
        }
        return count;
    }
}