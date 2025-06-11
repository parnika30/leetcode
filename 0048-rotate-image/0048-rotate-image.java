class Solution {
    public void rotate(int[][] matrix) {
        int l = 0;
        int r = matrix.length - 1;

        while(l<r){
            for(int i = 0; i<r-l;i++){
                int top = l, bottom = r;
                
                // Save the top-left
                int topLeft = matrix[top][l + i];

                // Move bottom-left to top-left
                matrix[top][l + i] = matrix[bottom - i][l];

                // Move bottom-right to bottom-left
                matrix[bottom - i][l] = matrix[bottom][r - i];

                // Move top-right to bottom-right
                matrix[bottom][r - i] = matrix[top + i][r];

                // Move top-left to top-right
                matrix[top + i][r] = topLeft;
            }
            l++; r--;
        }


        
    }
}