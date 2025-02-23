class Solution {
    public boolean isValidSudoku(char[][] board) {

    //traverse row-wise
        for(int row = 0 ; row<9 ; row++ ){
            HashSet<Character> hs = new HashSet<Character>();
            for(int i = 0 ; i<9 ; i++ ){
                if(board[row][i] == '.') {
                    continue;
                }else if (hs.contains(board[row][i])){
                    return false;
                }
                hs.add(board[row][i]);
            }
        }

    //traverse col-wise
        for(int col = 0 ; col<9 ; col++ ){
            HashSet<Character> hs = new HashSet<Character>();
            for(int i = 0 ; i<9 ; i++ ){
                if(board[i][col] == '.') {
                    continue;
                }else if (hs.contains(board[i][col])){
                    return false;
                }else {
                    hs.add(board[i][col]);
                }
            }
        }


    //traverse square-wise (3*3) for 9 squares
        for(int sq = 0 ; sq<9 ; sq++ ){
            HashSet<Character> hs = new HashSet<Character>();
            for(int i = 0 ; i<3 ; i++ ){
                for( int j =0; j<3 ; j++){
                    int row = (sq/3) * 3 + i;
                    int col = (sq%3) * 3 + j;
                    if(board[row][col] == '.') {
                        continue;
                    }else if (hs.contains(board[row][col])){
                        return false;
                    }else {
                        hs.add(board[row][col]);
                    }
                }
            }
        }
        return true;
    }
}