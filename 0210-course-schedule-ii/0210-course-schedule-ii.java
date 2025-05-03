// class Solution {
//     public int[] findOrder(int numCourses, int[][] prerequisites) {
//        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

//         for (int i = 0; i < numCourses; i++) {
//             adj.add(new ArrayList<>());
//         }

//         for (int[] edge : prerequisites) {
//             int u = edge[1]; // course
//             int v = edge[0]; // preprerequisite
//             adj.get(u).add(v);
//         }
        
//         int[] indeg = new int[numCourses];
//         //figuring out the indegree of each element 
//         for(int i =0; i< numCourses ;i++){
//             for(int ele : adj.get(i)){
//                 indeg[ele]++; //indeg[1]++ (incoming edge to 1)
//             }
//         }
        
//         Queue<Integer> q = new LinkedList<Integer>();
//         for(int i =0; i< numCourses ;i++){
//             if(indeg[i]==0) q.add(i); //start from the ele whose indeg is 0
//         }
            
//         //ArrayList<Integer> topo = new ArrayList<>();
//         int[] topo = new int[numCourses];
//         int i = 0;
//         while(!q.isEmpty()){
//             int node = q.peek(); 
//             q.remove();
//             topo[i++] = node;
            
//             //since node is in topo sort, remove from indegree
//             for(int ele : adj.get(node)){
//                 indeg[ele]--;
//                 if(indeg[ele] == 0) q.add(ele);
//             }
//         }

//         if(i == numCourses) return topo;
//         else return new int[]{};
//     }
// }

//using dfs
class Solution {
    private boolean dfs(ArrayList<ArrayList<Integer>> adj, Stack<Integer> st, int[] vis, int node){
        vis[node] =1; //visiting
        for(int i : adj.get(node)){
            if(vis[i] ==1) return false;
            if(vis[i]==0) {
                if(!dfs(adj,st,vis,i)) return false;
            }
        }
        vis[node] = 2;
        st.push(node);
        return true;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
       ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : prerequisites) {
            int u = edge[1]; // course
            int v = edge[0]; // preprerequisite
            adj.get(u).add(v);
        }
        
        int[] vis = new int[numCourses];
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = 0; i<numCourses; i++){
            if(vis[i]==0) {
                if(!dfs(adj,st,vis,i)) {
                    return new int[] {};
                }
            }
        }
        
        int[] res = new int[numCourses];
        int index = 0;
        while (!st.isEmpty()) {
            res[index++] = st.pop();
        }
        return res;
    }
}