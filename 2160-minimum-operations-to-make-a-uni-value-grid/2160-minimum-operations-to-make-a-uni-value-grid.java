class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int elements = m * n;
        int[] newArr = new int[elements];
        int index = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                newArr[index++] = grid[i][j];
            }
        }

        Arrays.sort(newArr);
        int mid = elements/2;
        int median = newArr[mid];

        for(int value : newArr){
            if(Math.abs(value-median) % x !=0){
                return -1;
            }else{
                count += Math.abs(value-median) / x ;
            }
        }
        return count;
    }
}

// Flattening → O(m × n)
// Sorting → O(k log k) or O((m × n) log (m × n))
// Calculating Operations → O(m × n)
// Total Time Complexity: \U0001d442(\U0001d45a⋅\U0001d45b⋅log(\U0001d45a⋅\U0001d45b))