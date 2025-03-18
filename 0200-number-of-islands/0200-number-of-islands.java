class Solution {

    private void bfs(int row, int col, int vis[][], char[][] grid, int n,int m){
        vis[row][col] =1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row, col});

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];    

            int[] dRow = {-1, 1, 0, 0}; // Up, Down
            int[] dCol = {0, 0, -1, 1}; // Left, Right

                for (int i = 0; i < 4; i++) {
                    int nr = r + dRow[i];
                    int nc = c + dCol[i];

                    if(nr>=0 && nc>=0 && nr< n && nc<m 
                    && grid[nr][nc] == '1' //land
                    && vis[nr][nc] == 0){ // not visited
                        vis[nr][nc] = 1;
                        q.add(new int[]{nr, nc});
                    } 
                }
        }
    }


    //to find no of islands
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        int count = 0;
        for(int row =0; row<n;row++){
            for(int col = 0; col<m;col++){
                if(vis[row][col] == 0 && grid[row][col]== '1') { //grid is land as well
                    count++;
                    bfs(row,col, vis,grid, n,m);
                }
                
            }
        }
        return count;
    }
}