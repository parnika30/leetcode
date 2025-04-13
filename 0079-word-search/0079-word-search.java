class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;

        boolean[][] vis = new boolean[row][col];
        for(int r =0;r<row;r++){
            for(int c=0;c<col;c++){
                if(dfs(r,c,0,word,vis,board)) return true;
            }
        }
        return false;
    }
    private boolean dfs(int r ,int c, int currInd, String word, boolean[][] vis, char[][] board){
        if(word.length() == currInd) return true;  //end of the word => found the word

        int row = board.length;
        int col = board[0].length;

        //checks for out of bounds conditions
        if(r <0 || c<0 || r>=row || c>=col ||
        board[r][c] != word.charAt(currInd) || vis[r][c]){ // don’t revisit a cell, already included in the current DFS path
            return false;
        }

        //You mark the path you're walking (visited[r][c] = true)
        // You go deeper (DFS).
        // If the path doesn't work, you backtrack and erase your footprints (visited[r][c] = false) so you can try new paths.
        vis[r][c] = true;
        boolean res = dfs(r+1,c,currInd+1,word, vis,board) || dfs(r-1,c,currInd+1,word, vis,board) ||
                        dfs(r,c+1,currInd+1, word,vis,board) || dfs(r,c-1,currInd+1, word,vis,board);

        vis[r][c] = false;
        return res;
    } 
}