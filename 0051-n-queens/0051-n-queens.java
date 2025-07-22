class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();

        Set<Integer> cols = new HashSet<>();
        Set<Integer> posDiags = new HashSet<>();
        Set<Integer> negDiags = new HashSet<>();

        char[][] board = new char[n][n];
        for(char[] row : board){
            Arrays.fill(row,'.');
        }

        backtrack(0, n, board, res, cols, posDiags, negDiags);

        return res;
    }

    private void backtrack(int row, int n, char[][] board,
                        List<List<String>> res, Set<Integer> cols,
                        Set<Integer> posDiags, Set<Integer> negDiags){
        
        //base case : if all rows are filled, n reached last row, add board to res
        if(row == n){
            List<String> config = new ArrayList<>();
            for(char[] c : board){
                config.add(new String(c));
            }
            res.add(config);
            return;
        }

        //placing a q in each col of curr row
        for(int col=0; col<n; col++){
            int posD = row + col;
            int negD = row - col;

            if(cols.contains(col) || posDiags.contains(posD) || negDiags.contains(negD)) continue;

            cols.add(col);
            posDiags.add(posD);
            negDiags.add(negD);
            board[row][col] = 'Q';

            backtrack(row+1, n, board, res, cols, posDiags, negDiags);

            cols.remove(col);
            posDiags.remove(posD);
            negDiags.remove(negD);
            board[row][col] = '.';
        }
    
    }

}