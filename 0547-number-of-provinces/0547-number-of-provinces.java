class Solution {
    private void dfs(int node, ArrayList<ArrayList<Integer>> adjL, int[] vis){
        vis[node] = 1;
        for(int i : adjL.get(node)){
            if(vis[i] == 0){
                dfs(i,adjL,vis);
            }
        }
    }
    
    public int findCircleNum(int[][] isConnected) {
        
        //change adj matrix to list
        ArrayList<ArrayList<Integer>> adjL = new ArrayList<ArrayList<Integer>>();
        int V = isConnected.length; // Number of cities (nodes)

        // Initialize adjacency list
        for(int i = 0; i<V; i++){
            adjL.add(new ArrayList<Integer>());
        }

        // Convert adjacency matrix to adjacency list
        for(int i = 0; i<V ;i++){
            for(int j = 0; j<V ;j++){
                if(isConnected[i][j] == 1 && i != j){
                    adjL.get(i).add(j);
                    adjL.get(j).add(i);
                }
            }
        }

        int[] vis = new int[V];
        int count = 0;

        // Perform DFS for each unvisited node
        for(int i =0;i<V;i++){
            if(vis[i] == 0){
                count++;
                dfs(i,adjL,vis);
            }
        }
        return count;
    }
} 
