class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = -1;
            }
        }

        return rec(grid, 0,0, m, n, dp);
    }

    private int rec(int[][] grid,  int i, int j, int m, int n, int[][] dp){
        if(i==m-1 && j==n-1) return grid[i][j];
        if(i>=m || j>=n) return Integer.MAX_VALUE;
        if(dp[i][j]!=-1) return dp[i][j];

        int right = rec(grid, i, j+1, m,n, dp);
        int down = rec(grid, i+1, j, m,n,dp);

        return dp[i][j] = grid[i][j] + Math.min(right, down);
    }
}