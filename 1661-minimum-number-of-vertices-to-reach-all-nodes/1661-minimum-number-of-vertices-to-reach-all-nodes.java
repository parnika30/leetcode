class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(List<Integer> edge : edges){
            int u = edge.get(0);
            int v = edge.get(1);
            adj.get(u).add(v);
        }

        int[] indeg = new int[n];
        for(int i =0;i<n;i++){
            for(int ele : adj.get(i)){
                indeg[ele]++; //har element ka indeg hoga
            }
        }
        
        for(int i =0;i<n;i++){
            if(indeg[i]==0){ 
                res.add(i);
            }
        }

        return res;

    }
}