//do using dfs - reviseee
class Solution {
    private void dfs(int[][] ans, int[][] image , int newColor, int row, int col, int[] deltaR, int[] deltaC, int color){
        ans[row][col] = color;
        int n = ans.length;
        int m = ans[0].length;
        for(int i = 0; i<4; i++){
            int nr = row + deltaR[i];
            int nc = col + deltaC[i];
            if(nr >= 0 && nr < n && nc >= 0 && nc < m 
            && image[nr][nc] == newColor && ans[nr][nc] != color){
                dfs(ans,image, newColor, nr, nc, deltaR, deltaC, color);
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] ans = image;
        int newColor = image[sr][sc];
        int[] deltaR = {-1,0,+1,0};
        int[] deltaC = {0,+1,0,-1};
        dfs(ans, image, newColor, sr, sc, deltaR, deltaC, color);
        return ans; 
    }
}