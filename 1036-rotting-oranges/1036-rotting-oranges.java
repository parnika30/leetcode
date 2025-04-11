class Pair {
    int row;
    int col;
    int t;

    Pair(int row, int col, int t) {
        this.row = row;
        this.col = col;
        this.t = t;
    }
}


class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int freshCount = 0;
        int rottenCount = 0;

        Queue<Pair> q = new LinkedList<>();
        //{{row,col},t}
        int[][] vis = new int[n][m];
         for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j]==2){
                    q.add(new Pair(i,j, 0));
                    vis[i][j] = 2;
                }else{
                    vis[i][j] = 1; 
                }

                if(grid[i][j] ==1){ // 1 : fresh oRange
                    freshCount++;
                }
            }
        }

        int time = 0;
        int[] delR = {-1,0,1,0};
        int[] delC = {0,1,0,-1};
        while(!q.isEmpty()){
            int r = q.peek().row;//first row
            int c = q.peek().col;//first col
            int t = q.peek().t;
            q.remove();
            time = Math.max(t,time);

            for(int i =0;i<4;i++){
                int nRow = r+delR[i];
                int nCol = c+delC[i];
                if(nRow >= 0 && nCol >= 0 && nRow<n && nCol<m
                && vis[nRow][nCol] !=2 //previosly not rotten
                && grid[nRow][nCol] == 1) //fresh orange and not rotten
                {
                    q.add(new Pair(nRow,nCol, time+1)); 
                    vis[nRow][nCol] = 2;
                    rottenCount ++;
                }
                
            }
        }
        if(rottenCount!=freshCount){
            return -1;
        }
        return time;
    }
}