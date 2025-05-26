class Solution {
    private void bfs(int[][]vis, char[][] grid, int r, int c){
        int gr = grid.length;
        int gc = grid[0].length;
        Queue<int[]> q = new LinkedList<>();

        vis[r][c] = 1;
        q.add(new int[] {r,c});

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1]; 

            // int[] delR = {-1,1,0,0};
            // int[] delC = {0,0,-1,1};

            int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

            for(int[] dir : directions){
                int nr = row + dir[0];
                int nc = col + dir[1];

                if(nr>=0 && nc>=0 && 
                    nr<gr && nc<gc && vis[nr][nc] == 0 && grid[nr][nc] == '1'){
                    vis[nr][nc] = 1;
                    q.add(new int[] {nr,nc});
                }
            }

            // for(int i = 0;i<4;i++){
            //     int nr = r + delR[i];
            //     int nc = c + delC[i];

            //     if(nr>=0 && nc>=0 && nr<mainRow && nc<mainCol && vis[nr][nc] == 0 && grid[nr][nc] == '1'){
            //         vis[nr][nc] = 1;
            //         q.add(new int[] {nr,nc});
            //     }
            // }
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][]vis = new int[n][m];
        int count = 0;

        for (int i =0; i<n;i++){
            for (int j =0; j<m;j++){
                if(vis[i][j] == 0 && grid[i][j] == '1'){ //grid is land
                    count++;
                    bfs(vis,grid,i,j);
                    bfs(vis,grid,i,j);
                } 
            }
        }

        return count;
    }
}