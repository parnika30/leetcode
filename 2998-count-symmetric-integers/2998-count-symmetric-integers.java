class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for(int i = low; i<=high; i++){
            String s = Integer.toString(i);
            int len = s.length();

            if(len % 2 !=0) continue;
            int mid = len/2;

            int left = 0, right = 0;

            for(int j=0; j<mid; j++){
                left += s.charAt(j) - '0';
                right += s.charAt(j+mid) - '0'; 
                // -0 converts the character to its actual integer value by subtracting the ASCII value of '0'
            }
            if(left == right){
                count++;
            }
        }
        return count;
    }
}