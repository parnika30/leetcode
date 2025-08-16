class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][]vis = new int[m][n];
        int count =0;
        int maxArea = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j] ==0 && grid[i][j] == 1){
                    count++;
                    int area = bfs(i,j,grid,vis);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    private static int bfs(int r, int c, int[][] grid, int[][] vis){
        //gr, gc, direc, q -> q traverse krnas hai, jab tak q empty nhi hota 
        int gr = grid.length;
        int gc = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int area = 1;

        vis[r][c] = 1;
        q.add(new int[]{r,c});


        while(!q.isEmpty()){
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];

            //phele x axis -> 1,-1, then yaxis -> 1,-1
            int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

            for(int[] dir : directions){
                int nr = row + dir[0];
                int nc = col + dir[1];

                if(nr>=0 && nc>=0 && nr<gr && nc<gc && 
                    vis[nr][nc] ==0 && grid[nr][nc] == 1){
                        vis[nr][nc] = 1;
                        q.add(new int[] {nr, nc});
                        area++;
                }
            }
        }

        return area;
    }
}