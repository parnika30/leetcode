class Solution {
    public int deleteGreatestValue(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int total = 0;

        for(int i = 0;i<rows; i++){
            Arrays.sort(grid[i]);
        }

        for(int j = 0; j<cols; j++){
            int maxInCol = Integer.MIN_VALUE;
            for(int i = 0; i<rows; i++){
                maxInCol = Math.max(grid[i][j], maxInCol);
            }
            total += maxInCol; 
        }

        return total;

    }
}