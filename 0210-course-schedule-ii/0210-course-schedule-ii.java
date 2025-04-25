class Solution {
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
        
        int[] indeg = new int[numCourses];
        //figuring out the indegree of each element 
        for(int i =0; i< numCourses ;i++){
            for(int ele : adj.get(i)){
                indeg[ele]++; //indeg[1]++ (incoming edge to 1)
            }
        }
        
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i =0; i< numCourses ;i++){
            if(indeg[i]==0) q.add(i); //start from the ele whose indeg is 0
        }
            
        //ArrayList<Integer> topo = new ArrayList<>();
        int[] topo = new int[numCourses];
        int i = 0;
        while(!q.isEmpty()){
            int node = q.peek(); 
            q.remove();
            topo[i++] = node;
            
            //since node is in topo sort, remove from indegree
            for(int ele : adj.get(node)){
                indeg[ele]--;
                if(indeg[ele] == 0) q.add(ele);
            }
        }

        if(i == numCourses) return topo;
        else return new int[]{};
    }
}