//algo: 
// 1. using dfs, capture unsurrounded regions, "O" -> "#"
// 2. capture surrounded regions, "O" -> "X"
// 3. convert "#" -> "O" again. 



class Solution {
    int rows, cols;
    private void dfs(char[][] board, int r, int c){
        if(r<0 || c<0 || r>= rows || c>= cols || board[r][c] != 'O'){
            return;
        }
        board[r][c] = '#';
        dfs(board, r+1, c);
        dfs(board, r-1, c);
        dfs(board, r, c+1);
        dfs(board, r, c-1);

    }
    public void solve(char[][] board) {
        rows = board.length;
        cols = board[0].length;
        if(board == null || board.length == 0) return;

        //1
        for(int i = 0; i<rows; i++){
            for(int j =0; j<cols; j++){
                if(board[i][j] == 'O' && 
                (i==0 || j==0 || i == rows-1 || j == cols-1)){ //last row, last col
                    dfs(board, i,j);
                } 
            }
        }

        //2
        for(int i = 0; i<rows; i++){
            for(int j =0; j<cols; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
            }
        }

        //3
        for(int i = 0; i<rows; i++){
            for(int j =0; j<cols; j++){
                if(board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }
}