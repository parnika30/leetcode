class Solution {
    private void bfs(int[][]vis, char[][] grid, int mainRow, int mainCol, int gr, int gc){
        vis[gr][gc] = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {gr,gc});

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1]; 

            int[] delR = {-1,1,0,0};
            int[] delC = {0,0,-1,1};

            for(int i = 0;i<4;i++){
                int nr = r + delR[i];
                int nc = c + delC[i];

                if(nr>=0 && nc>=0 && nr<mainRow && nc<mainCol && vis[nr][nc] == 0 && grid[nr][nc] == '1'){
                    vis[nr][nc] = 1;
                    q.add(new int[] {nr,nc});
                }
            }
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
                    bfs(vis,grid,n,m,i,j);
                } 
            }
        }

        return count;
    }
}