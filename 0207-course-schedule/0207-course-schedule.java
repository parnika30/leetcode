class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        //adjacency list
        //dfs 

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        Stack<Integer> st = new Stack<>();
        for(int[] edge : prerequisites){
            int u = edge[0];
            int v = edge[1];
            adj.get(v).add(u);
        }

        int vis[] = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(vis[i]==0){
                if(!dfs(vis,i,adj,st))return false;
            }
        }

        int[] res = new int[numCourses];
        int ind = 0;

        while(!st.isEmpty()){
            res[ind++] = st.pop();
        }

        if(res.length == numCourses)return true;
        return false; 

    }

    private boolean dfs(int[] vis,int node,ArrayList<ArrayList<Integer>>adj, Stack st){
        vis[node] = 1;
        for(int i : adj.get(node)){
            if(vis[i]==1) return false;
            if(vis[i]==0){
                if(!dfs(vis,i,adj,st))return false;
            }
        }

        vis[node] = 2;
        st.push(node);
        return true;
    }
}