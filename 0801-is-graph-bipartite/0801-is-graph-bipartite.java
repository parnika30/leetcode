//using BFS
//TC - O(V + E) traverses each node once. 

class Solution {
    private boolean checkBipartite(ArrayList<ArrayList<Integer>> adj, int[] color, int start, int V){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0; 

        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();

            for(int i : adj.get(node)){
                if(color[i] == -1){
                    color[i] = 1-color[node];
                    q.add(i);
                }else if(color[i] == color[node]){
                    return false;
                }   
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        //converting to adj list
        int n = graph.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int neighbor : graph[i]) {
                adj.get(i).add(neighbor);
            }
        } //O(V + E)

        int[] color = new int[n];
        Arrays.fill(color,-1);

        for(int i = 0; i<n; i++){
            if(color[i] == -1){
                if(checkBipartite(adj,color,i,n) == false) return false;
            }
        }
        return true;
    }
}