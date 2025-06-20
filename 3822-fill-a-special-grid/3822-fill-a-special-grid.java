class Solution {
    public int[][] specialGrid(int n) {
        int exp = 2 * n;
        int pow = (int) Math.pow(2,exp);
        int size = (int) Math.pow(2,n);
        int grid[][] = new int[size][size];
        fill(grid,0,0,size,0);
        return grid;
    }


    private void fill(int[][] grid, int r, int c, int size, int start){
        if( size == 1){
            grid[r][c] = start;
            return;
        }

        int quarter = size * size / 4;
        int half = size/2;

        fill(grid,r,c,half, start + 3*quarter); //top left
        fill(grid,r+half, c,half, start + 2*quarter); //bottom left
        fill(grid,r+half, c+half ,half, start + quarter); //bottom riht
        fill(grid,r, c+half, half, start); //top right
    }
}

//O(2^{2n})