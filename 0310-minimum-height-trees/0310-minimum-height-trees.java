class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        List<Integer> res = new ArrayList<>();

        if(n==1) {
            res.add(0); 
            return res;
        }

        List<List<Integer>> adj = new ArrayList<>();
        int[] indeg = new int[n];

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        //1 & 2
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            indeg[u]++;
            indeg[v]++;
        }

        //3
        Queue<Integer> q = new LinkedList<>();
        for(int i =0; i<n; i++){
            if(indeg[i] == 1){
                q.offer(i);
            }
        }
        
        //4
        while(n > 2){
            int size = q.size();
            n = n-size; 

            for(int i=0; i< size; i++){
                int leaf = q.poll();
                for(int neigh : adj.get(leaf)){
                    indeg[neigh]--;
                    if(indeg[neigh] == 1){
                        q.offer(neigh);
                    }
                } 
            } 
        }

        //5
        while(!q.isEmpty()){
            res.add(q.poll());
        }

        return res;
    }

}

// 1.build adj list 
// 2. build indeg arr 
// 3. add leafs to queue
// 4. do bfs and remove the leafs until <=2 leafs remian
// 5. add the remaing leafs (MHT) to the final res. 