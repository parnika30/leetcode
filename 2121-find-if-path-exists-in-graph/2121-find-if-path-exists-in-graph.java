class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] vis = new boolean[n];
        dfs(source,vis,adj);
        return vis[destination];  //If destination gets marked visited, path exists.

    }

    private void dfs(int source, boolean[] vis, List<List<Integer>> adj){
        vis[source] = true;
        for(int node : adj.get(source)){
            if(vis[node]==false){
                dfs(node,vis,adj);
            }
        }
    }
}