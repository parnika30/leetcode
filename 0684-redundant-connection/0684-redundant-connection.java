class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = edges.length;
        List<Integer> res = new ArrayList<>(); 

        for(int i=0;i<=V;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int[] vis = new int[V+1];
            if(samepath(u,v,adj,vis)){
                return new int[]{u,v};
            }
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return new int[0];
    }

    
    private static boolean samepath(int u, int v,ArrayList<ArrayList<Integer>>adj, int[] vis){
        if(u==v)return true;
        vis[u] = 1;
        for(int i : adj.get(u)){
            if(vis[i]==0){
                if(samepath(i,v,adj,vis)){
                    return true;
                }
            }
        }
        return false;
    }


}