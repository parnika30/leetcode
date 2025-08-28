class Solution {
    public int[][] sortMatrix(int[][] grid) {
        //diagonal -> if(m==n) girid[row][col] = diagonal -> sort in desc 
        //bottom left -> Use a max-heap for desc order
        //top right -> Use a min-heap for asc order

       //  i-j > 0 -> bottom left : desc
       // i-j < 0 -> top right : asc

        int row = grid.length, col = grid[0].length;
        Map<Integer, PriorityQueue<Integer>> diagonal = new HashMap<>();

        for(int i=0; i<row; i++){
            for(int j=0;j<col;j++){
                int key = i-j;
                diagonal.putIfAbsent(key, key < 0 ? new PriorityQueue<>() : new PriorityQueue<>(Collections.reverseOrder())); 
                diagonal.get(key).offer(grid[i][j]);
            }
        }

        for(int i=0; i<row; i++){
            for(int j=0;j<col;j++){
                int key = i-j;
                grid[i][j] = diagonal.get(key).poll();
            }
        }

        return grid;

    }
}