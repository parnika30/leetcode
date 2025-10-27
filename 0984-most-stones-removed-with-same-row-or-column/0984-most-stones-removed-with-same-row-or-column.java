class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0; i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(stones[i][0] == stones[j][0] || 
                    stones[i][1] == stones[j][1]){
                        adj.get(i).add(j);
                        adj.get(j).add(i);
                    }
            }
        }

        int connectedComp = 0;
        int[] vis = new int[n];

        for(int i=0;i<n;i++){
            if(vis[i] == 0){
                dfs(vis, adj, i);
                connectedComp++;

            }
        }

        return n - connectedComp; 
    }

    private void dfs(int[] vis, ArrayList<ArrayList<Integer>> adj, int node){
        vis[node] = 1;
        for(int neighbour : adj.get(node)){
            if(vis[neighbour]==0){
                dfs(vis, adj, neighbour);
            }
        }
    }
}